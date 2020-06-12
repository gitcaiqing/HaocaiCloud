package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransOrder;

public interface TransOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransOrder record);

    int insertSelective(TransOrder record);

    TransOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransOrder record);

    int updateByPrimaryKey(TransOrder record);
}