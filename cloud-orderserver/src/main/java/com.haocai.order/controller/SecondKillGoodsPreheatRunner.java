package com.haocai.order.controller;

import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.order.config.RedisUtil;
import com.haocai.order.service.SecondKillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 秒杀商品缓存预热
 */
@Component
public class SecondKillGoodsPreheatRunner implements ApplicationRunner {

    @Autowired
    SecondKillGoodsService secondKillGoodsService;

    private Long goodsId =1L;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        SecondKillGoods secondKillGoods = secondKillGoodsService.get(goodsId);
        if(secondKillGoods == null){
            return;
        }

        //删除缓存中原数据
        redisUtil.del("remain"+goodsId);

        redisUtil.set("remain"+goodsId, secondKillGoods.getRemain());

    }
}
