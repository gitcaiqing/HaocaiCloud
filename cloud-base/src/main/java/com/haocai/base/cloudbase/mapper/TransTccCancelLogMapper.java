package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.entity.TransTccCancelLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTccCancelLogMapper extends BaseMapper<TransTccCancelLog> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTccCancelLog record);

    int insertSelective(TransTccCancelLog record);

    TransTccCancelLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccCancelLog record);

    int updateByPrimaryKey(TransTccCancelLog record);

    int countCancel(@Param("txNo") String txNo);
}