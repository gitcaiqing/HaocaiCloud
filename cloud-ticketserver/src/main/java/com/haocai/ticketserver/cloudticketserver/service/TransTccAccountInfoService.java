package com.haocai.ticketserver.cloudticketserver.service;
import org.dromara.hmily.annotation.Hmily;

public interface TransTccAccountInfoService {

    @Hmily
    void updateAmountInfo(Long amount);
}
