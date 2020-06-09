package com.haocai.ticketserver.cloudticketserver.Exception;

import com.haocai.base.cloudbase.vo.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/9 14:57
 **/
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseMessage handleBusinessException(BusinessException e) {
        //log.error(e.getMessage(), e);
        log.error(e.getMessage());
        return ResponseMessage.error(e.getStatus(), e.getMessage());
    }
}
