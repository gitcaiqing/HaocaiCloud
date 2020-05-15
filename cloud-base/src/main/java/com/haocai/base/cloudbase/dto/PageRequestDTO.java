package com.haocai.base.cloudbase.dto;

import com.haocai.base.cloudbase.entity.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 16:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO<T> {

    //数据记录
    private T bean;

    private Page<T> page;
}
