package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.haocai.base.cloudbase.entity.TransLearningCourse;
import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.entity.TransTaskHis;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.mapper.TransLearningCourseMapper;
import com.haocai.base.cloudbase.mapper.TransTaskHisMapper;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.TransLearningCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/15 14:19
 **/
@Service
public class TransLearningCourseServiceImpl implements TransLearningCourseService {


    @Autowired
    private TransTaskHisMapper transTaskHisMapper;

    @Autowired
    private TransLearningCourseMapper transLearningCourseMapper;

    @Override
    @Transactional
    public ResponseMessage addLearningCourse(TransTask transTask) {
        try {
            String taskUuid = transTask.getTaskUuid();
            TransTaskHis transTaskHis = transTaskHisMapper.selectByUuid(taskUuid);
            if(Objects.nonNull(transTaskHis)){
                transTaskHis.setUpdatedTime(new Date());
                transTaskHis.setVersion(transTaskHis.getVersion()+1);
                transTaskHisMapper.updateByPrimaryKey(transTaskHis);
                return ResponseMessage.ok();
            }

            //添加课程
            TransLearningCourse transLearningCourse = new TransLearningCourse();
            transLearningCourse.setCourseUuid(UuidUtil.getUuid());
            transLearningCourse.setCreatedTime(new Date());
            transLearningCourse.setStatus(StatusEnum.A.getValue());
            TransOrder transOrder = JSON.parseObject(transTask.getMqRequestBody(), TransOrder.class);
            transLearningCourse.setOrderNo(transOrder.getOrderNo());
            transLearningCourse.setCharge(transOrder.getAmount().intValue());
            transLearningCourse.setPrice(10L);
            transLearningCourseMapper.insertSelective(transLearningCourse);

            //插入消费历史记录
            transTaskHis = new TransTaskHis();
            transTaskHis.setMqRoutingKey(transTask.getMqRoutingKey());
            transTaskHis.setMqRequestBody(transTaskHis.getMqRequestBody());
            transTaskHis.setTaskHisUuid(transTask.getTaskUuid());
            transTaskHis.setCreatedTime(new Date());
            transTaskHis.setStatus(StatusEnum.A.getValue());
            transTaskHisMapper.insertSelective(transTaskHis);

            return ResponseMessage.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("添加选课失败");
        }
    }
}
