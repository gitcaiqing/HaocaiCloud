package com.haocai.ticketserver.cloudticketserver.kafka;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.haocai.base.cloudbase.entity.TransLearningCourse;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.entity.TransTaskHis;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.mapper.TransTaskHisMapper;
import com.haocai.base.cloudbase.util.ValidUtil;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.TransLearningCourseService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/15 13:17
 **/
@Component
@Slf4j
public class OrderListener {

    @Autowired
    private TransLearningCourseService transLearningCourseService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = {"topic_order"})
    public void consumer(ConsumerRecord consumerRecord) {
        Optional kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info("kafka消费者接收到的consumerRecord：{}", kafkaMessage);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            TransTask transTask = JSON.parseObject(message.toString(), TransTask.class);
            log.info("kafka消费的消息 transTask：{}", transTask);

            ResponseMessage res = transLearningCourseService.addLearningCourse(transTask);
            if(ValidUtil.requestSuccess(res)){
                //添加选课成功
                kafkaTemplate.send("topic_learning", JSON.toJSONString(transTask));
            }

        }
    }

}