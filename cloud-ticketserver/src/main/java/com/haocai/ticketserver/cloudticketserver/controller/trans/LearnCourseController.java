package com.haocai.ticketserver.cloudticketserver.controller.trans;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/trans/learn")
@Slf4j
public class LearnCourseController {

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<TransOrder> createOrder(){
        return null;
    }
}
