package com.haocai.base.cloudbase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haocai.base.cloudbase.enums.AcceptanceStatusEnum;
import com.haocai.base.cloudbase.enums.DeploymentStatusEnum;
import com.haocai.base.cloudbase.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class OmProject {
    private Long id;

    private String projectUuid;

    private Long workId;

    private String projectType;

    private String title;

    private String communicationGroup;

    private String dockingPeople;

    private DeploymentStatusEnum deploymentStatus;

    private AcceptanceStatusEnum acceptanceStatus;

    private String memo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date completeTime;

    private StatusEnum status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    private String createdBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    private String updatedBy;

    private Long version;

}