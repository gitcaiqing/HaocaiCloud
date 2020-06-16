package com.haocai.order.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.mapper.TransTaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/12 16:52
 **/
@Component
@Slf4j
public class TransOrderSchedule {

    @Autowired
    private TransTaskMapper transTaskMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "0 */1 * * * ?")
    public void transOrderTask(){

        //查询任务（当前时间一分钟之前的），推送到消息队列,
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, -1);
        Date aMinuteAgoTime = calendar.getTime();


        List<TransTask> transTaskList = transTaskMapper.listByTime(aMinuteAgoTime);
        log.info("--------处理{}至{}，时间段的任务数据数量:{}--------", aMinuteAgoTime, now, transTaskList.size());
        transTaskList.forEach(transTask -> {
            //往消息队列发送信息
            kafkaTemplate.send(transTask.getMqRoutingKey(), JSON.toJSONString(transTask));
            log.info("transOrderTask 往消息队列：{} 推送数据：{}", transTask.getMqRoutingKey(), transTask);
        });
    }
}
