package com.haocai.base.cloudbase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransTccCancelLog {
    private Long id;

    private String serviceName;

    private String txNo;

    private Date createTime;
}