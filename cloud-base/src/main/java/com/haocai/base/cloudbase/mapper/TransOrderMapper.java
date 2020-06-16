package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransOrder;
import org.springframework.stereotype.Repository;


@Repository
public interface TransOrderMapper extends BaseMapper<TransOrder>{
    int deleteByPrimaryKey(Long id);

    Integer insert(TransOrder record);

    int insertSelective(TransOrder record);

    TransOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransOrder record);

    int updateByPrimaryKey(TransOrder record);
}