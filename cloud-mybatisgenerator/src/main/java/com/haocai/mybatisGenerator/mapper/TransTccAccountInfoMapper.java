package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTccAccountInfo;

public interface TransTccAccountInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTccAccountInfo record);

    int insertSelective(TransTccAccountInfo record);

    TransTccAccountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccAccountInfo record);

    int updateByPrimaryKey(TransTccAccountInfo record);
}