package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 15:09
 **/
public enum CodeEnum {
    UNKNOWN("-1"),
    SUCCESS("0");

    private String value;

    private CodeEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }
}
