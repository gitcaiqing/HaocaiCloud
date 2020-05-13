package com.haocai.ticketfront.cloudticketfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("/ssm/basicUser")
public class BasicUserController {
	
	//@Autowired
	//private BasicUserService basicUserService;

	@RequestMapping("/listPage")
	public String listBasicUser() {
		return "/basicUser/list";
	}
	
	/*@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public Object users(BasicUser basicUser, Page<BasicUser> page) {
		return basicUserService.listBasicUser(basicUser, page);
	}*/
}
