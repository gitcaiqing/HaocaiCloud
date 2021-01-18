package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.SecondKillOrder;

public interface SecondKillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecondKillOrder record);

    int insertSelective(SecondKillOrder record);

    SecondKillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondKillOrder record);

    int updateByPrimaryKey(SecondKillOrder record);
}