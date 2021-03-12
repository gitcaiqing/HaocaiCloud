package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.base.cloudbase.mapper.SecondKillGoodsMapper;
import com.haocai.order.config.RedisUtil;
import com.haocai.order.service.SecondKillGoodsService;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class SecondKillGoodsServiceImpl implements SecondKillGoodsService {

    @Autowired
    private SecondKillGoodsMapper secondKillGoodsMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 根据商品ID获取商品信息
     * @param goodsId
     * @return
     */
    @Override
    public SecondKillGoods get(Long goodsId) {
        return secondKillGoodsMapper.selectByPrimaryKey(goodsId);
    }

    /**
     * 扣减库存
     * @param goodsId 商品ID
     * @param number 减少库存数
     * 并发请求时，同时获取到剩余最后一个库存时会出现超卖问题
     * @return
     */
    @Override
    public boolean reduceStock(Long goodsId, int number) {

        //return this.reduceStockById(goodsId, number);

        //启用乐观锁读取并更新库存
        return this.reduceStockByIdAndVersion(goodsId, number);
    }

    /**
     * 直接扣减库存-根据商品id更新库存信息
     * @param goodsId
     * @param number
     * @return
     */
    public boolean reduceStockById(Long goodsId, int number) {
        SecondKillGoods secondKillGoods = secondKillGoodsMapper.selectByPrimaryKey(goodsId);
        if(secondKillGoods == null){
            //商品不存在
            log.error("商品：{}不存在", goodsId);
            return false;
        }
        if(number > secondKillGoods.getRemain()){
            //库存不足，扣减库存失败
            log.error("商品：{}库存小于：{}，扣减失败", goodsId, number);
            return false;
        }
        //库存充足，扣减库存
        secondKillGoods.setRemain(secondKillGoods.getRemain() - number);
        secondKillGoods.setSale(secondKillGoods.getSale() + number);
        secondKillGoods.setVersion(secondKillGoods.getVersion() + 1);
        int row = secondKillGoodsMapper.updateByPrimaryKey(secondKillGoods);
        if(row <= 0){
            //更新数据库 执行扣减库存失败
            log.error("商品：{} 更新数据库库存，扣减失败", goodsId);
            return false;
        }
        log.info("商品：{} 更新数据库库存，扣减库存成功", goodsId);
        return true;
    }

    /**
     * 根据商品Id和版本信息更新库存信息
     * @param goodsId 商品ID
     * @param number 数据
     * 获取商品库存是同时获取当前版本号，更新库存数量时携带版本号作为参数
     * @return
     */
    public boolean reduceStockByIdAndVersion(Long goodsId, int number){

        //先查询redis缓存的商品信息
        Long remain = Long.valueOf(String.valueOf(redisUtil.get("remain"+goodsId)));
        SecondKillGoods secondKillGoods = new SecondKillGoods();
        if(Objects.isNull(remain) || remain == 0){
            //根据商品Id 查询商品库存信息
            //高并发场景下数据库查询频繁，所以引入redis缓存库存信息
            secondKillGoods = secondKillGoodsMapper.selectByPrimaryKey(goodsId);
            if(secondKillGoods == null){
                //商品不存在
                log.error("商品：{}不存在", goodsId);
                return false;
            }
            remain = secondKillGoods.getRemain();
        }

        if(number > remain){
            //库存不足，扣减库存失败
            log.error("商品：{}库存小于：{}，扣减失败", goodsId, number);
            return false;
        }
        //库存充足，扣减库存
        secondKillGoods.setId(goodsId);
        secondKillGoods.setRemain(secondKillGoods.getRemain() - number);
        secondKillGoods.setSale(secondKillGoods.getSale() + number);
        int row = secondKillGoodsMapper.updateByPrimaryKeyAndVersion(secondKillGoods);
        if(row <= 0){
            //版本号和获取时不一致，更新数据库 执行扣减库存失败（乐观锁）
            log.error("商品：{} 更新数据库库存，扣减失败", goodsId);
            return false;
        }
        log.info("商品：{} 更新数据库库存，扣减库存成功", goodsId);

        //更新缓存中的库存信息
        redisUtil.decr("remain"+goodsId, number);
        return true;
    }

    /**
     * 通过redis校验库存，如果redis缓存中未命中查询数据库
     * @param goodsId
     * @param number
     * @return
     */
    @Override
    public SecondKillGoods checkGoodsRemain(Long goodsId, int number){
        Long remain = Long.valueOf(String.valueOf(redisUtil.get("remain"+goodsId)));
        SecondKillGoods secondKillGoods = null;
        if(Objects.isNull(remain)){
            //根据商品Id 查询商品库存信息
            //高并发场景下数据库查询频繁，所以引入redis缓存库存信息
            secondKillGoods = secondKillGoodsMapper.selectByPrimaryKey(goodsId);
            if(secondKillGoods == null){
                //商品不存在
                log.error("商品：{}不存在", goodsId);
                return null;
            }
        }else{
            secondKillGoods = new SecondKillGoods();
            secondKillGoods.setId(goodsId);
            secondKillGoods.setRemain(remain);
        }

        if(secondKillGoods.getRemain() < number){
            //库存不足，扣减库存失败
            log.error("商品：{}库存小于：{}，扣减失败", goodsId, number);
            return null;
        }
        //库存充足
        return secondKillGoods;
    }

    /**
     * 增加库存
     * @param goodsId 商品ID
     * @param number 增加库存数
     * @return
     */
    @Override
    public boolean increaseStock(Long goodsId, int number) {
        SecondKillGoods secondKillGoods = secondKillGoodsMapper.selectByPrimaryKey(goodsId);
        if(secondKillGoods == null){
            //商品不存在
            log.error("商品：{}不存在", goodsId);
            return false;
        }
        //库存充足，扣减库存
        secondKillGoods.setRemain(secondKillGoods.getRemain() + number);
        int row = secondKillGoodsMapper.updateByPrimaryKey(secondKillGoods);
        if(row <= 0){
            //更新数据库 执行增加库存失败
            log.error("商品：{} 更新数据库库存，增加失败", goodsId);
            return false;
        }
        log.info("商品：{} 更新数据库库存，增加库存成功", goodsId);
        return true;
    }
}
