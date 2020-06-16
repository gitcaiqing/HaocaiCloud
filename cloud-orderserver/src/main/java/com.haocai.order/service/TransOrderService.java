package com.haocai.order.service;

import com.haocai.base.cloudbase.entity.TransOrder;
import com.haocai.base.cloudbase.entity.TransTask;

public interface TransOrderService {

    TransOrder createOrder();

    void deleteTransTaskByTaskUuid(String taskUuid);

    TransTask selectTransTaskByUuid(String taskUuid);
}
