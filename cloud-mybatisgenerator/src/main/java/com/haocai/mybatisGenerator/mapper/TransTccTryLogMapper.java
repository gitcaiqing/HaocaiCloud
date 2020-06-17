package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTccTryLog;

public interface TransTccTryLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTccTryLog record);

    int insertSelective(TransTccTryLog record);

    TransTccTryLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccTryLog record);

    int updateByPrimaryKey(TransTccTryLog record);
}