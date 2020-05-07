package com.haocai.ticketserver.cloudticketserver.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import com.haocai.base.cloudbase.vo.PageResult;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/4/30 11:15
 **/
@Controller
@RequestMapping("/ticketCategory")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ticketCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseMessage<PageResult<List<TbTicketCategory>>> list(TicketCategoryReqPage request){
        PageResult<List<TbTicketCategory>> results = ticketCategoryService.listTicketCategoryPage(request);
        return ResponseMessage.ok(results);
    }

    @RequestMapping("/selectById/{id}")
    @ResponseBody
    public ResponseMessage<TbTicketCategory> selectById(@PathVariable(value = "id") Long id){
        return ResponseMessage.ok(ticketCategoryService.selectById(id));
    }
}
