package com.haocai.base.cloudbase.exception;

import lombok.Data;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/9 14:58
 **/
@Data
public class BusinessException extends RuntimeException{

    private Integer status = 201;

    private String message;

    public BusinessException() {
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
