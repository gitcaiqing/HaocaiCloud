package com.haocai.ticketfront.cloudticketfront.service;

import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import com.haocai.base.cloudbase.vo.PageResult;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 16:55
 **/
@FeignClient(value = "cloud-ticketserver")
public interface BasicUserServiceFeign {

    //@RequestMapping(value="/basicUser/users", method = RequestMethod.GET)
    //Object users(@RequestParam(value = "basicUser", required = false) BasicUser basicUser);

    @RequestMapping("/ticketCategory/list")
    ResponseMessage<List<TbTicketCategory>> list(@RequestParam("name") String name);

    @RequestMapping("/ticketCategory/selectById/{id}")
    ResponseMessage<TbTicketCategory> selectById(@RequestParam("id") Long id);
}
