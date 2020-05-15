package com.haocai.ticketserver.cloudticketserver.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import com.haocai.base.cloudbase.vo.PageResult;

import java.util.List;

public interface TicketCategoryService extends IService<TbTicketCategory> {

    TbTicketCategory selectById(Long id);

    List<TbTicketCategory> listTicketCategoryPage(TicketCategoryReqPage request);
}
