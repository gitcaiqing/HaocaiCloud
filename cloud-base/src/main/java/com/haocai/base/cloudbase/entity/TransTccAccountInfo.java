package com.haocai.base.cloudbase.entity;

import lombok.Data;

@Data
public class TransTccAccountInfo {
    private Long id;

    private String accountName;

    private String accountNo;

    private String accountPassword;

    private Long accountBalance;
}