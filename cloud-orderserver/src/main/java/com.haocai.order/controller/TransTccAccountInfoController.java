package com.haocai.order.controller;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.service.TransOrderService;
import com.haocai.order.service.TransTccAccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 14:53
 **/
@Controller
@RequestMapping("/trans/tcc/amount")
@Slf4j
public class TransTccAccountInfoController {
    @Autowired
    private TransTccAccountInfoService transTccAccountInfoService;

    /**
     * 发起转账
     * @param
     * @author CQ
     */
    @RequestMapping(value="/transfer")
    @ResponseBody
    public ResponseMessage transfer(@RequestParam Long amount){

        transTccAccountInfoService.updateAccount(amount);
        return  ResponseMessage.ok("转账成功");

    }
}
