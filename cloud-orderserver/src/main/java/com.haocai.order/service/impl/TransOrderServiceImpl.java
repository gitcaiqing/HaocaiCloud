package com.haocai.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.mapper.TransOrderMapper;
import com.haocai.base.cloudbase.mapper.TransTaskMapper;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.order.service.TransOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

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
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(transOrder);
        TransTask transTask = new TransTask();
        transTask.setTaskUuid(UuidUtil.getUuid());
        transTask.setMqExchange(null);
        transTask.setMqRoutingKey("topic_order");
        transTask.setMqRequestBody(jsonObject.toJSONString());
        transTask.setCreatedTime(now);
        transTask.setStatus(StatusEnum.A.getValue());
        transTaskMapper.insertSelective(transTask);

        return transOrder;
    }

    @Override
    public void deleteTransTaskByTaskUuid(String taskUuid) {
        Optional<TransTask> transTaskOptional = Optional.ofNullable(transTaskMapper.selectByUuid(taskUuid));
        if(transTaskOptional.isPresent()){
            TransTask transTask = transTaskOptional.get();
            transTask.setStatus(StatusEnum.D.getValue());
            transTaskMapper.updateByPrimaryKeySelective(transTask);
        }
    }

    @Override
    public TransTask selectTransTaskByUuid(String taskUuid) {
        return transTaskMapper.selectByUuid(taskUuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredNew2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupports1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupports2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupports2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }

    @Override
    public void addNoSupports1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    public void addNoSupports2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    public void addNoSupports2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatory1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatory2(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00002");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatory2Exception(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void addNever1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U00001");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupportedException1(Date now) {
        TransOrder transOrder = new TransOrder();
        transOrder.setOrderNo("R"+now.getTime());
        transOrder.setAmount(1000L);
        transOrder.setUserId("U000022");
        transOrder.setCreatedTime(now);
        transOrder.setStatus(StatusEnum.A.getValue());
        transOrderMapper.insertSelective(transOrder);
        throw new RuntimeException();
    }
}
