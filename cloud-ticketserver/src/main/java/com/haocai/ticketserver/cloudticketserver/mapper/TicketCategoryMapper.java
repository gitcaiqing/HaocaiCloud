package com.haocai.ticketserver.cloudticketserver.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.haocai.base.cloudbase.dto.TicketCategoryReqPage;
import com.haocai.base.cloudbase.entity.TbTicketCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 13:29
 **/
@Repository
public interface TicketCategoryMapper extends BaseMapper<TbTicketCategory> {

    TbTicketCategory selectById(Long id);

    /**
     * 返回总记录数
     * @param page
     * @return
     */
    Long count(TicketCategoryReqPage page);

    /**
     * 根据条件获取列表
     * @param page
     * @return
     */
    List<TbTicketCategory> findPage(TicketCategoryReqPage page);
}
