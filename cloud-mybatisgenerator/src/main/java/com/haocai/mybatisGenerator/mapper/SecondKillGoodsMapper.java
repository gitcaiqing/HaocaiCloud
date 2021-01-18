package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.SecondKillGoods;

public interface SecondKillGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecondKillGoods record);

    int insertSelective(SecondKillGoods record);

    SecondKillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondKillGoods record);

    int updateByPrimaryKey(SecondKillGoods record);
}