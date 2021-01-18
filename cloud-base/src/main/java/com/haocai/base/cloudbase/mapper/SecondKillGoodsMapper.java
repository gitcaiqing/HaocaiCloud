package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.base.cloudbase.entity.TransTccAccountInfo;

public interface SecondKillGoodsMapper extends BaseMapper<SecondKillGoods> {
    int deleteByPrimaryKey(Long id);

    Integer insert(SecondKillGoods record);

    int insertSelective(SecondKillGoods record);

    SecondKillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondKillGoods record);

    int updateByPrimaryKey(SecondKillGoods record);
}