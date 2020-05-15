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
@RestController
@RequestMapping("/ticketCategory")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ticketCategoryService;

    @RequestMapping("/list")
    public ResponseMessage<List<TbTicketCategory>> list(@RequestParam String name){
        System.out.println(name);
        TicketCategoryReqPage request = new TicketCategoryReqPage();
        List<TbTicketCategory> tbTicketCategories = ticketCategoryService.listTicketCategoryPage(request);
        return ResponseMessage.ok(tbTicketCategories);
    }

    @RequestMapping("/selectById/{id}")
    public ResponseMessage<TbTicketCategory> selectById(@PathVariable(value = "id") Long id){
        return ResponseMessage.ok(ticketCategoryService.selectById(id));
    }
}
