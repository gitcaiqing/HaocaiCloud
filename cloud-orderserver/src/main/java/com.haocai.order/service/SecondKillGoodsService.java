package com.haocai.order.service;

import com.haocai.base.cloudbase.entity.SecondKillGoods;

public interface SecondKillGoodsService {

    //获取秒杀商品信息
    SecondKillGoods get(Long goodsId);

    //判断库存是否充足并预扣减库存
    boolean reduceStock(Long goodsId, int number);

    //校验商品库存
    SecondKillGoods checkGoodsRemain(Long goodsId, int number);

    //增加库存 -- 当扣减库存失败或订单超时未支付则返还库存
    boolean increaseStock(Long goodsId, int number);
}
