package com.haocai.ticketfront.cloudticketfront.controller.kd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 11:22
 **/
@Controller
@RequestMapping("/om/deployFile")
public class DeployDataController {

    @RequestMapping("/listPage")
    public String listPage() {
        return "deployFile/list";
    }
}
