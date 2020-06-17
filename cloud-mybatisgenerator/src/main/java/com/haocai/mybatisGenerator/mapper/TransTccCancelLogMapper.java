package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTccCancelLog;

public interface TransTccCancelLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTccCancelLog record);

    int insertSelective(TransTccCancelLog record);

    TransTccCancelLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccCancelLog record);

    int updateByPrimaryKey(TransTccCancelLog record);
}