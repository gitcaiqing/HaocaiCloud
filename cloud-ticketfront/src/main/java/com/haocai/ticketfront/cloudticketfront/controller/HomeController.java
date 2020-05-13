package com.haocai.ticketfront.cloudticketfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 主页控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("ssm")
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		//BasicUser basicUser = WebUtils.getCurrentUser();
		//model.addAttribute("basicUser", basicUser);
		return "index";
	}

}
