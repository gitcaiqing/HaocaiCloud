package com.haocai.base.cloudbase.entity;

import com.haocai.base.cloudbase.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:33
 **/
@Data
public class TbOmDeployPackage implements Serializable {

    private Long id;
    private String packageUuid;
    private String dolphinVersion;
    private String projectType;
    private String projectVersion;
    private String packName;
    private String packUrl;
    private StatusEnum urlExpired;
    private StatusEnum status;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
    private Long version;

}
