package com.haocai.order.service;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.entity.TransTask;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TransOrderService {

    TransOrder createOrder();

    void deleteTransTaskByTaskUuid(String taskUuid);

    TransTask selectTransTaskByUuid(String taskUuid);

    void addRequired1(Date now);

    void addRequired2(Date now);

    void addRequired2Exception(Date now);

    void addRequiredNew1(Date now);

    void addRequiredNew2(Date now);

    void addRequiredNew2Exception(Date now);

    void addNested1(Date now);

    void addNested2(Date now);

    void addNested2Exception(Date now);

    void addSupports1(Date now);

    void addSupports2(Date now);

    void addSupports2Exception(Date now);

    void addNoSupports1(Date now);

    void addNoSupports2(Date now);

    void addNoSupports2Exception(Date now);

    void addMandatory1(Date now);

    void addMandatory2(Date now);

    void addMandatory2Exception(Date now);

    void addNever1(Date now);

    void addNotSupportedException1(Date now);
}
