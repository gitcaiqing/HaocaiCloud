package com.haocai.order.service;

import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.vo.SecondKillVO;

public interface SecondKillOrderService {

    SecondKillOrder create(Long goodsId, String name, Long phone);

    SecondKillOrder consumerTopicToCreateOrderWithKafka(Long goodsId, String name, Long phone);
}
