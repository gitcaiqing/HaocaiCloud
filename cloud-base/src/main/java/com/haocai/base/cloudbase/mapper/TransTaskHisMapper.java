package com.haocai.base.cloudbase.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.haocai.base.cloudbase.entity.TransTaskHis;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransTaskHisMapper extends BaseMapper<TransTaskHis> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTaskHis record);

    int insertSelective(TransTaskHis record);

    TransTaskHis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTaskHis record);

    int updateByPrimaryKey(TransTaskHis record);

    TransTaskHis selectByUuid(String taskUuid);

    List<TransTaskHis> listByTime(Date aMinuteAgoTime);
}