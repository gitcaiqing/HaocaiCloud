package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransTccAccountInfo;
import com.haocai.base.cloudbase.entity.TransTccConfirmLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTccConfirmLogMapper extends BaseMapper<TransTccConfirmLog> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransTccConfirmLog record);

    int insertSelective(TransTccConfirmLog record);

    TransTccConfirmLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransTccConfirmLog record);

    int updateByPrimaryKey(TransTccConfirmLog record);

    int countConfirm(@Param("txNo") String txNo);
}