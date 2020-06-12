package com.haocai.base.cloudbase.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TransOrder {
    private Long id;

    private String orderUuid;

    private String orderNo;

    private Long amount;

    private String userId;

    private String status;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Long version;

}