package com.haocai.ticketserver.cloudticketserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/4/30 11:15
 **/
@Controller
public class TicketCategoryController {

    @RequestMapping("/ticketCategory/list")
    @ResponseBody
    public String list(){
        return "ticketCategory list";
    }
}
