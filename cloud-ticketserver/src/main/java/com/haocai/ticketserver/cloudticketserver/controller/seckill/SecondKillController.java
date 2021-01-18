package com.haocai.ticketserver.cloudticketserver.controller.seckill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 秒杀入口
 */
@RequestMapping("/secondKill")
@RestController
public class SecondKillController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
