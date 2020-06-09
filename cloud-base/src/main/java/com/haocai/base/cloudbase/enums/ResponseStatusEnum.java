package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 15:09
 **/
public enum ResponseStatusEnum {
    OK(200),
    ERROR(500),
    NOT_FOUND(404),
    BAD_REQUEST(400),
    BUSINESS_EXCEPTION(201);

    private Integer value;

    ResponseStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
