package com.haocai.base.cloudbase.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.haocai.base.cloudbase.entity.TransTask;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTaskMapper extends BaseMapper<TransTask> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTask record);

    int insertSelective(TransTask record);

    TransTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTask record);

    int updateByPrimaryKey(TransTask record);
}