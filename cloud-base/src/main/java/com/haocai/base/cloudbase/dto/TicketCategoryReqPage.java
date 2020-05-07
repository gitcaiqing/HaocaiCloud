package com.haocai.base.cloudbase.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 16:05
 **/
@Data
public class TicketCategoryReqPage implements Serializable {

    /**
     * 分页信息
     */
    private PageQuery page;
    /**
     * 分类名称
     */
    private String name;
}
