package com.haocai.order.controller;

import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.service.SecondKillGoodsService;
import com.haocai.order.service.SecondKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondKill")
public class SecondKillController {

    @Autowired
    private SecondKillService secondKillService;

    @RequestMapping("/createOrder")
    public ResponseMessage createOrder(@RequestParam(required = true) Long goodsId,
                                       @RequestParam(required = true) String name,
                                       @RequestParam(required = true) Long phone){

        return secondKillService.placeCreateOrder(goodsId, name, phone);
    }
}
