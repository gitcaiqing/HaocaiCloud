package com.haocai.base.cloudbase.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TransTask {
    private Long id;

    private String taskUuid;

    private String taskType;

    private String mqExchange;

    private String mqRoutingKey;

    private String mqRequestBody;

    private String errorMessage;

    private String status;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Long version;

}