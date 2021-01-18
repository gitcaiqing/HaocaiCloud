package com.haocai.base.cloudbase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondKillOrder {
    private Long id;

    //下单人名称
    private String placeName;

    //下单人电话
    private Long placePhone;

    //商品ID
    private Long goodsId;

    //下单时间
    private Date createdTime;

    //更新时间
    private Date updatedTime;

    private Integer version;

}