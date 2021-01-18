package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.SecondKillGoods;
import com.haocai.base.cloudbase.entity.SecondKillOrder;

public interface SecondKillOrderMapper extends BaseMapper<SecondKillOrder> {
    int deleteByPrimaryKey(Long id);

    Integer insert(SecondKillOrder record);

    int insertSelective(SecondKillOrder record);

    SecondKillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondKillOrder record);

    int updateByPrimaryKey(SecondKillOrder record);
}