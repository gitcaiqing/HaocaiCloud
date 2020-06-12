package com.haocai.order.controller;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.service.TransOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/12 14:36
 **/
@Controller
@RequestMapping("/trans/order")
@Slf4j
public class TransOrderController {

    @Autowired
    private TransOrderService transOrderService;

    @RequestMapping(value="/create")
    @ResponseBody
    public ResponseMessage<TransOrder> createOrder(){
        log.info("开始下单...");
        try {
            return ResponseMessage.ok(transOrderService.createOrder());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下单失败");
        }
    }
}
