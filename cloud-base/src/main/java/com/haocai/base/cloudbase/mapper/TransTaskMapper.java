package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransTaskMapper extends BaseMapper<TransTask> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTask record);

    int insertSelective(TransTask record);

    TransTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTask record);

    int updateByPrimaryKey(TransTask record);

    List<TransTask> listByTime(@Param("aMinuteAgoTime") Date aMinuteAgoTime);

    TransTask selectByUuid(String taskUuid);
}