package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTccAccountInfoMapper extends BaseMapper<TransTccAccountInfo> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTccAccountInfo record);

    int insertSelective(TransTccAccountInfo record);

    TransTccAccountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccAccountInfo record);

    int updateByPrimaryKey(TransTccAccountInfo record);

    TransTccAccountInfo getAmountInfoByAmountNo(String amountNo);
}