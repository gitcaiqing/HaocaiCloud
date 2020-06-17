package com.haocai.order.service;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 16:02
 **/
public interface TransTccAccountInfoService {

    void updateAccount(Long amount);
}
