package com.haocai.order.service;

import com.haocai.base.cloudbase.entity.SecondKillOrder;

public interface SecondKillOrderService {

    SecondKillOrder create(Long goodsId, String name, Long phone);
}
