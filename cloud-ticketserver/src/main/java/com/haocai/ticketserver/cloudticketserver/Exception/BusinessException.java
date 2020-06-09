package com.haocai.ticketserver.cloudticketserver.Exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
