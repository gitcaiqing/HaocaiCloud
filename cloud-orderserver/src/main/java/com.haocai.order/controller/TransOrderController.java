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

import java.util.Date;

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

        try {
            TransOrder transOrder = null;
            for(int i=0; i<10; i++){
                log.info("开始下单...{}", new Date());
                transOrder = transOrderService.createOrder();
                Thread.sleep(500);
            }
            return  ResponseMessage.ok(transOrder);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下单失败");
        }
    }
}
