package com.haocai.base.cloudbase.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TransLearningCourse {
    private Long id;

    private String courseUuid;

    private String userId;

    private String orderNo;

    private Long price;

    private Integer charge;

    private String status;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Long version;

}