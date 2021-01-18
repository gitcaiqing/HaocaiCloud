package com.haocai.order.service;

import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.springframework.stereotype.Service;

public interface SecondKillService {

    //下单
    ResponseMessage placeCreateOrder(Long goodsId, String name, Long phone);
}
