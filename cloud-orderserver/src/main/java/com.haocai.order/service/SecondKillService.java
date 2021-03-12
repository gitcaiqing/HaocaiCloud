package com.haocai.order.service;

import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface SecondKillService {

    //下单
    ResponseMessage placeCreateOrder(Long goodsId, String name, Long phone);

    //redis缓存库存信息 ，下单信息异步推送至kafka
    @Transactional
    ResponseMessage createOrderWithRedisAndKafka(Long goodsId, String name, Long phone);
}
