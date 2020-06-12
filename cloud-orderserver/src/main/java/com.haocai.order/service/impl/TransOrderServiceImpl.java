package com.haocai.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.mapper.TransOrderMapper;
import com.haocai.base.cloudbase.mapper.TransTaskMapper;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.order.service.TransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/12 14:49
 **/
@Service
public class TransOrderServiceImpl implements TransOrderService {

    @Autowired
    private TransOrderMapper transOrderMapper;

    @Autowired
    private TransTaskMapper transTaskMapper;
    @Override
    @Transactional
    public TransOrder createOrder() {

        TransOrder transOrder = new TransOrder();
        transOrder.setOrderUuid(UuidUtil.getUuid());
        Date now = new Date();
        transOrder.setOrderNo("T"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrderMapper.insertSelective(transOrder);

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(transOrder);
        TransTask transTask = new TransTask();
        transTask.setTaskUuid(UuidUtil.getUuid());
        transTask.setMqExchange(null);
        transTask.setMqRoutingKey("order_topic");
        transTask.setMqRequestBody(jsonObject.toJSONString());
        transTaskMapper.insertSelective(transTask);
        return transOrder;
    }
}
