package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.entity.TransTccTryLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTccTryLogMapper extends BaseMapper<TransTccTryLog> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTccTryLog record);

    int insertSelective(TransTccTryLog record);

    TransTccTryLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccTryLog record);

    int updateByPrimaryKey(TransTccTryLog record);

    int countTry(@Param("txNo") String txNo);
}