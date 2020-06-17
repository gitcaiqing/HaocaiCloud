package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTccConfirmLog;

public interface TransTccConfirmLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTccConfirmLog record);

    int insertSelective(TransTccConfirmLog record);

    TransTccConfirmLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccConfirmLog record);

    int updateByPrimaryKey(TransTccConfirmLog record);
}