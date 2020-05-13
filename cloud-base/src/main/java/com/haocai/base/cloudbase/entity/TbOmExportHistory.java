package com.haocai.base.cloudbase.entity;

import lombok.Data;

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
    private String status;
    private String createdTime;
    private String createdBy;
    private String updated_time;
    private String updatedBy;
    private String version;

}
