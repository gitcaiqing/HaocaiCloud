package com.haocai.ticketserver.cloudticketserver.schedule;

import com.alibaba.fastjson.JSON;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.entity.TransTaskHis;
import com.haocai.base.cloudbase.mapper.TransTaskHisMapper;
import com.haocai.base.cloudbase.mapper.TransTaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/12 16:52
 **/
@Component
@Slf4j
public class TransLearningCourseSchedule {

    @Autowired
    private TransTaskHisMapper transTaskHisMapper;

    @Autowired
    private TransTaskMapper transTaskMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 添加完选课成功发送mq崩溃或异常，定时任务进行mq消息补发
     * @param
     * @return void
     * @author CQ
     * @date 2020/6/15 16:17
     */
    @Scheduled(cron = "0 */5 * * * ?")
    public void transTaskHisTask(){

        //查询任务（当前时间五分钟之前的），推送到消息队列,
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, -5);
        Date aMinuteAgoTime = calendar.getTime();

        List<TransTaskHis> transTaskHisList = transTaskHisMapper.listByTime(aMinuteAgoTime);
        log.info("--------处理{}至{}，时间段的任务数据数量:{}--------", aMinuteAgoTime, now, transTaskHisList.size());
        transTaskHisList.forEach(transTaskHis -> {
            TransTask transTask = transTaskMapper.selectByUuid(transTaskHis.getTaskHisUuid());
            if(Objects.nonNull(transTaskHis)){
                //往消息队列发送信息
                kafkaTemplate.send(transTask.getMqRoutingKey(), JSON.toJSONString(transTask));
                log.info("transTaskHisTask 往消息队列：{} 推送数据：{}", transTask.getMqRoutingKey(), transTask);
            }
        });
    }
}
