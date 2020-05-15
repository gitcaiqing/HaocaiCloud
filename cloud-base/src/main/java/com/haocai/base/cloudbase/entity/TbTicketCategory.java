package com.haocai.base.cloudbase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 9:55
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTicketCategory implements Serializable {

    public Long id;

    public String tcUuid;

    public String name;
}
