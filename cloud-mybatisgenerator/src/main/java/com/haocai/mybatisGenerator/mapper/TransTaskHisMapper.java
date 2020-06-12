package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTaskHis;

public interface TransTaskHisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTaskHis record);

    int insertSelective(TransTaskHis record);

    TransTaskHis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTaskHis record);

    int updateByPrimaryKey(TransTaskHis record);
}