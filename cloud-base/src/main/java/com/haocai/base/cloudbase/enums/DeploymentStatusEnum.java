package com.haocai.base.cloudbase.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/13 10:53
 **/
@Getter
public enum DeploymentStatusEnum {
    START("START", "部署开始"),
    END("END", "部署结束");

    private String value;

    private String label;

    DeploymentStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
