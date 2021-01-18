package com.haocai.order.kafka;

import com.alibaba.fastjson.JSON;
import com.haocai.base.cloudbase.entity.SecondKillOrder;
import com.haocai.base.cloudbase.enums.TopicEnum;
import com.haocai.base.cloudbase.vo.SecondKillVO;
import com.haocai.order.service.SecondKillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 秒杀下单异步消息监听
 */
@Component
@Slf4j
public class SecondKillListener {

    @Autowired
    private SecondKillOrderService secondKillOrderService;

    //@KafkaListener(topics = {"SecondKillTopic"})
    //public void ConsumeSecondKillCreateOrder(ConsumerRecord consumerRecord){
     //   Optional consumerRecordOptional = Optional.ofNullable(consumerRecord);
        //如果消息不为空
   //     if(consumerRecordOptional.isPresent()){
   //         SecondKillVO secondKillVO = JSON.parseObject(consumerRecordOptional.get().toString(), SecondKillVO.class);
            //创建订单
    //        secondKillOrderService.create(secondKillVO.getGoodsId(), secondKillVO.getName(), secondKillVO.getPhone());
    //    }
   // }
}
