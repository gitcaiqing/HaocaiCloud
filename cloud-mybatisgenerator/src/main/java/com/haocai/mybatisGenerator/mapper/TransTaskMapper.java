package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransTask;

public interface TransTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransTask record);

    int insertSelective(TransTask record);

    TransTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTask record);

    int updateByPrimaryKey(TransTask record);
}