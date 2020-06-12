package com.haocai.order.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/12 16:52
 **/
@Component
@Slf4j
public class TransOrderSchedule {

    @Scheduled(cron = "0/1 * * * * *")
    public void transOrderTask(){
        log.info("定时任务：{} 开始运行...", "transOrderTask");

    }
}
