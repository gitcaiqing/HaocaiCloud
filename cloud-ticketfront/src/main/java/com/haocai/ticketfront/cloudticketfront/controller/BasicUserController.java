package com.haocai.ticketfront.cloudticketfront.controller;

import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import com.haocai.base.cloudbase.vo.PageResult;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.BasicUserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("/ssm/basicUser")
public class BasicUserController {
	
	@Autowired
	private BasicUserServiceFeign basicUserServiceFeign;

	@RequestMapping("/listPage")
	public String listBasicUser() {
		return "/basicUser/list";
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<List<TbTicketCategory>> users(BasicUser basicUser, Page<BasicUser> page) {
		TicketCategoryReqPage ticketCategoryReqPage = new TicketCategoryReqPage();
		ticketCategoryReqPage.setName("a");
		ResponseMessage<List<TbTicketCategory>> result = basicUserServiceFeign.list("aaaaaa");
		return result;
	}

	@RequestMapping(value="/selectById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<TbTicketCategory> selectById() {
		ResponseMessage<TbTicketCategory> result = basicUserServiceFeign.selectById(1L);
		return result;
	}
}
