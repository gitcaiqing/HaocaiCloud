package com.haocai.ticketfront.cloudticketfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
