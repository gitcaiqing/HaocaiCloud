package com.haocai.base.cloudbase.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondKillVO implements Serializable {

    private Long goodsId;

    private String name;

    private Long phone;
}
