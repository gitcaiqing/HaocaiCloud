package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 10:53
 **/
public enum ProjectTypeEnum {
    CTSERVER("CTSERVER", "CTSERVER"),
    KMAPSERVER("KMAPSERVER", "KMAPSERVER");

    private String value;

    private String label;

    private ProjectTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
