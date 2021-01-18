package com.haocai.base.cloudbase.entity;

import lombok.Data;

@Data
public class SecondKillGoods {
    private Long id;

    private String name;

    //库存总数
    private Long count;

    //剩余库存
    private Long remain;

    //已销售数
    private Long sale;

    private Integer version;

}