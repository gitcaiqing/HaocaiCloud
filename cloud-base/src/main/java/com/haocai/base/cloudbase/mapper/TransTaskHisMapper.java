package com.haocai.base.cloudbase.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.haocai.base.cloudbase.entity.TransTaskHis;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTaskHisMapper extends BaseMapper<TransTaskHis> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTaskHis record);

    int insertSelective(TransTaskHis record);

    TransTaskHis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTaskHis record);

    int updateByPrimaryKey(TransTaskHis record);
}