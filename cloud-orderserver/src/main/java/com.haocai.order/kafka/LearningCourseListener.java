package com.haocai.order.kafka;

import com.alibaba.fastjson.JSON;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.order.service.TransOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/15 13:17
 **/
@Component
@Slf4j
public class LearningCourseListener {

    @Autowired
    private TransOrderService transOrderService;

    @KafkaListener(topics = {"topic_learning"})
    public void consumer(ConsumerRecord consumerRecord) {
        Optional kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info("kafka消费者接收到的consumerRecord：{}", kafkaMessage);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            TransTask transTask = JSON.parseObject(message.toString(), TransTask.class);
            log.info("kafka消费的消息 transTask：{}", transTask);
            try {
                TransTask transTaskOld = transOrderService.selectTransTaskByUuid(transTask.getTaskUuid());
                if(Objects.nonNull(transTaskOld) && StatusEnum.A.getValue().equals(transTaskOld.getStatus())){
                    //将任务表中对应的任务删除
                    transOrderService.deleteTransTaskByTaskUuid(transTask.getTaskUuid());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}