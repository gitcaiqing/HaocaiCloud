package com.haocai.mybatisGenerator.entity;

import java.util.Date;

public class TransTaskHis {
    private Long id;

    private String taskHisUuid;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskHisUuid() {
        return taskHisUuid;
    }

    public void setTaskHisUuid(String taskHisUuid) {
        this.taskHisUuid = taskHisUuid == null ? null : taskHisUuid.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getMqExchange() {
        return mqExchange;
    }

    public void setMqExchange(String mqExchange) {
        this.mqExchange = mqExchange == null ? null : mqExchange.trim();
    }

    public String getMqRoutingKey() {
        return mqRoutingKey;
    }

    public void setMqRoutingKey(String mqRoutingKey) {
        this.mqRoutingKey = mqRoutingKey == null ? null : mqRoutingKey.trim();
    }

    public String getMqRequestBody() {
        return mqRequestBody;
    }

    public void setMqRequestBody(String mqRequestBody) {
        this.mqRequestBody = mqRequestBody == null ? null : mqRequestBody.trim();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}