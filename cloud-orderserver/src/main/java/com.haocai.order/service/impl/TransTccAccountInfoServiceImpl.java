package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.entity.TransTccCancelLog;
import com.haocai.base.cloudbase.entity.TransTccTryLog;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.mapper.TransTccAccountInfoMapper;
import com.haocai.base.cloudbase.mapper.TransTccCancelLogMapper;
import com.haocai.base.cloudbase.mapper.TransTccTryLogMapper;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.Feign.TransTccAmountInfoFeignService;
import com.haocai.order.service.TransTccAccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 16:02
 **/
@Service
@Slf4j
public class TransTccAccountInfoServiceImpl implements TransTccAccountInfoService {

    @Autowired
    private TransTccAccountInfoMapper transTccAccountInfoMapper;

    @Autowired
    private TransTccTryLogMapper transTccTryLogMapper;

    @Autowired
    private TransTccCancelLogMapper transTccCancelLogMapper;

    @Autowired
    private TransTccAmountInfoFeignService transTccAmountInfoFeignService;

    @Override
    @Hmily(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public void updateAccount(Long amount){

        //事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("order 服务开始 try 操作， 事务id:{}", transId);
        //幂等控制， 判断此事务是否已经进行过 try 操作

        //悬挂处理，如果已经提交或取消 则进行悬挂处理

        //从账户1扣减金额
        //判断账户金额是否足够
        TransTccAccountInfo amountInfo = transTccAccountInfoMapper.getAmountInfoByAmountNo("1");
        if(amountInfo == null){
            log.error("账户1中扣减失败，原因：账户1不存在，事务id{}", transId);
            throw new BusinessException("账户余额不足");
        }
        if(amountInfo.getAccountBalance() - amount < 0){
            log.error("账户1中扣减失败，原因：金额不足，事务id{}", transId);
            throw new BusinessException("账户余额不足");
        }

        //执行账号金额扣减
        amountInfo.setAccountBalance(amountInfo.getAccountBalance() - amount);
        transTccAccountInfoMapper.updateByPrimaryKey(amountInfo);

        //添加try操作日志
        TransTccTryLog transTccTryLog = new TransTccTryLog(null, "order",transId, new Date());
        transTccTryLogMapper.insertSelective(transTccTryLog);

        //调用另一个服务，为账号2 转账
        ResponseMessage responseMessage = transTccAmountInfoFeignService.transfer(amount);
        log.info("responseMessage:{}", responseMessage);
        log.info("order 服务结束 try 操作， 事务id:{}", transId);


    }

    public void confirmMethod(Long amount){
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("order 服务开始 confirm 操作， 事务id:{}", transId);

        //幂等校验，confirm 操作是否操作过

        log.info("order 服务结束 confirm 操作， 事务id:{}", transId);
    }

    public void cancelMethod(Long amount){
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("order 服务开始 cancel 操作， 事务id:{}", transId);

        //幂等校验，try 操作是否操作过
        if(transTccTryLogMapper.countTry(transId) <= 0){
            log.info("order 服务无 try 操作， 无需回滚， 事务id:{}", transId);
            return;
        }
        //幂等校验，cancel 操作是否操作过
        if(transTccCancelLogMapper.countCancel(transId) > 0){
            log.info("order 服务已执行 cancel 操作， 无需回滚， 事务id:{}", transId);
            return;
        }
        //执行回滚操作
        TransTccAccountInfo amountInfo = transTccAccountInfoMapper.getAmountInfoByAmountNo("1");
        if(amountInfo == null){
            log.error("账户1中回滚金额{}失败，原因：账户1不存在，事务id{}", amount, transId);
            throw new BusinessException("账户余额不足");
        }
        amountInfo.setAccountBalance(amountInfo.getAccountBalance() + amount);
        transTccAccountInfoMapper.updateByPrimaryKey(amountInfo);

        //添加cancel 操作日志
        TransTccCancelLog transTccCancelLog = new TransTccCancelLog(null, "order", transId, new Date());
        transTccCancelLogMapper.insertSelective(transTccCancelLog);

        log.info("order 服务结束 cancel 操作， 事务id:{}", transId);
    }

}
