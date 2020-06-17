package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.entity.TransTccConfirmLog;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.mapper.TransTccAccountInfoMapper;
import com.haocai.base.cloudbase.mapper.TransTccCancelLogMapper;
import com.haocai.base.cloudbase.mapper.TransTccConfirmLogMapper;
import com.haocai.ticketserver.cloudticketserver.service.TransTccAccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 16:43
 **/
@Service
@Slf4j
public class TransTccAccountInfoServiceImpl implements TransTccAccountInfoService {

    @Autowired
    private TransTccCancelLogMapper transTccCancelLogMapper;

    @Autowired
    private TransTccConfirmLogMapper transTccConfirmLogMapper;

    @Autowired
    private TransTccAccountInfoMapper transTccAccountInfoMapper;

    @Override
    @Hmily(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public void updateAmountInfo(Long amount){
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();

        log.info("server 服务开始 try 操作， 事务id:{}", transId);
    }

    public void confirmMethod(Long amount){
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("server 服务开始 confirm 操作， 事务id:{}", transId);

        //幂等校验，confirm 操作是否操作过
        if(transTccConfirmLogMapper.countConfirm(transId) > 0){
            log.info("server 服务已执行过 confirm 操作， 事务id:{}", transId);
            return;
        }
        TransTccAccountInfo accountInfo = transTccAccountInfoMapper.getAmountInfoByAmountNo("2");
        if(accountInfo == null){
            log.info("server 服务 confirm 操作失败，原因：账户2不存在， 事务id:{}", transId);
            throw new BusinessException("账号不存在");
        }

        //增加金额
        accountInfo.setAccountBalance(accountInfo.getAccountBalance() + amount);
        transTccAccountInfoMapper.updateByPrimaryKey(accountInfo);

        //添加confirm日志
        TransTccConfirmLog transTccConfirmLog = new TransTccConfirmLog(null, "server", transId, new Date());
        transTccConfirmLogMapper.insertSelective(transTccConfirmLog);
        log.info("server 服务结束 confirm 操作， 事务id:{}", transId);

    }

    public void cancelMethod(Long amount){
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("server 服务开始 cancel 操作， 事务id:{}", transId);

        log.info("server 服务结束 cancel 操作， 事务id:{}", transId);
    }

}
