package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.base.cloudbase.mapper.SecondKillGoodsMapper;
import com.haocai.order.service.SecondKillGoodsService;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SecondKillGoodsServiceImpl implements SecondKillGoodsService {

    @Autowired
    private SecondKillGoodsMapper secondKillGoodsMapper;

    /**
     * 扣减库存
     * @param goodsId 商品ID
     * @param number 减少库存数
     * 并发请求时，同时获取到剩余最后一个库存时会出现超卖问题
     * @return
     */
    @Override
    public boolean reduceStock(Long goodsId, int number) {
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
     *
     * @param goodsId 商品ID
     * @param number 数据
     * 获取商品库存是同时获取当前版本号，更新库存数量时携带版本号作为参数
     * @return
     */
    public boolean reduceStockByVersion(Long goodsId, int number){
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
        int row = secondKillGoodsMapper.updateByPrimaryKeyAndVersion(secondKillGoods);
        if(row <= 0){
            //更新数据库 执行扣减库存失败
            log.error("商品：{} 更新数据库库存，扣减失败", goodsId);
            return false;
        }
        log.info("商品：{} 更新数据库库存，扣减库存成功", goodsId);
        return true;
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
        log.error("商品：{} 更新数据库库存，增加库存成功", goodsId);
        return true;
    }
}
