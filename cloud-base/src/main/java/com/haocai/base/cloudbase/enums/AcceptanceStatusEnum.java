package com.haocai.base.cloudbase.enums;

import lombok.Getter;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 10:53
 **/
@Getter
public enum AcceptanceStatusEnum {
    UNSEND("UNSEND", "未发送验收报告"),
    SENDED("SENDED", "已发送验收报告"),
    ACCEPTED("ACCEPTED", "已验收");

    private String value;

    private String label;

    AcceptanceStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
