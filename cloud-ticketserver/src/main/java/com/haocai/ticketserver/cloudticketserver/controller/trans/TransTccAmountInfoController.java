package com.haocai.ticketserver.cloudticketserver.controller.trans;

import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.TransTccAccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 16:39
 **/
@Controller
@RequestMapping("/trans/tcc/amount")
@Slf4j
public class TransTccAmountInfoController {

    @Autowired
    private TransTccAccountInfoService transTccAccountInfoService;

    @RequestMapping("/transfer")
    @ResponseBody
    public ResponseMessage transfer(@RequestParam("amount") Long amount) {
        transTccAccountInfoService.updateAmountInfo(amount);
        return ResponseMessage.ok();
    }

}
