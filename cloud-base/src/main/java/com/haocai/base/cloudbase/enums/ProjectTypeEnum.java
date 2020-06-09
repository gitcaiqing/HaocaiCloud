package com.haocai.base.cloudbase.enums;

import lombok.Data;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 10:53
 **/
public enum ProjectTypeEnum {
    CTSERVER("CTSERVER", "Ct-Server"),
    KMAPSERVER("KMAPSERVER", "Kmap-Server");

    private String value;

    private String label;

    ProjectTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
