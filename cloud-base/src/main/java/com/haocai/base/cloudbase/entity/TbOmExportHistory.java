package com.haocai.base.cloudbase.entity;

import com.haocai.base.cloudbase.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 18:32
 **/
@Data
public class TbOmExportHistory {

    private Long id;
    private String exportUuid;
    private String dolphinVersion;
    private String projectType;
    private String projectVersion;
    private String zbType;
    private String dataType;
    private String exportContent;
    private StatusEnum status;
    private Date createdTime;
    private String createdBy;
    private Date updated_time;
    private String updatedBy;
    private Long version;

}
