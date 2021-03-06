package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.dto.PageQuery;
import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import com.haocai.base.cloudbase.mapper.TicketCategoryMapper;
import com.haocai.ticketserver.cloudticketserver.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/4/30 11:14
 **/
@Service
public class TicketCategoryServiceImpl extends ServiceImpl<TicketCategoryMapper,TbTicketCategory> implements TicketCategoryService{

    @Autowired
    TicketCategoryMapper ticketCategoryMapper;

    @Override
    public TbTicketCategory selectById(Long id) {
        return ticketCategoryMapper.selectById(id);
    }

    @Override
    public List<TbTicketCategory> listTicketCategoryPage(TicketCategoryReqPage param) {

        PageQuery page = param.getPage();
        if(page == null){
            page = new PageQuery();
            param.setPage(page);
        }
        Long count = baseMapper.count(param);
        if(count <= 0){
            return new ArrayList<>();
        }
        List<TbTicketCategory> list = baseMapper.findPage(param);
        return list;

        /*PageQuery page = param.getPage();
        if(page == null){
            page = new PageQuery();
            param.setPage(page);
        }
        Long count = baseMapper.count(param);
        if(count <= 0){
            return PageResult.resultPager(page.getPageNo(),page.getPageSize(),count,new ArrayList<TbTicketCategory>());
        }
        List<TbTicketCategory> list = baseMapper.findPage(param);
        return PageResult.resultPager(page.getPageNo(),page.getPageSize(),count,list);*/
    }
}
