package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.ticketserver.cloudticketserver.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 16:56
 **/
@Controller
@RequestMapping("/basicUser")
public class BasicUserController {

    @Autowired
    private BasicUserService basicUserService;

    @RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public Object users(BasicUser basicUser, Page<BasicUser> page) {
		return basicUserService.listBasicUser(basicUser, page);
	}
}
