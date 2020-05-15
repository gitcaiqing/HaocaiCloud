package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 15:09
 **/
public enum StatusEnum {

    A("A"),
    D("D");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }
}
