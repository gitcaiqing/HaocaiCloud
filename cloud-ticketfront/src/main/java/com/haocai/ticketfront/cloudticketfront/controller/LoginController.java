package com.haocai.ticketfront.cloudticketfront.controller;

import com.haocai.feign.cloudticketfeign.service.TicketCategoryFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/4/29 14:10
 **/
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginJsp")
    public String loginJsp() {
        return "loginJsp";
    }

    @Autowired
    private TicketCategoryFeignService ticketCategoryFeignService;

    @GetMapping(value = "/hi")
    @ResponseBody
    public String sayHi() {
        //return "a";//ticketCategoryFeignService;

        return ticketCategoryFeignService.list();
    }

}
