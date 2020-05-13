package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 10:53
 **/
public enum DataTypeEnum {
    REGIONRIVER("REGIONRIVER", "region和river"),
    COMMON("COMMON", "通用数据"),
    ADCODE320000("320000", "江苏省320000");

    private String value;

    private String label;

    private DataTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
