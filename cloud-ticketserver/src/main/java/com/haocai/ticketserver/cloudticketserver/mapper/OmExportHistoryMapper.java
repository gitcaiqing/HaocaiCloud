package com.haocai.ticketserver.cloudticketserver.mapper;


import com.haocai.base.cloudbase.entity.TbOmExportHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 18:55
 **/
@Repository
public interface OmExportHistoryMapper extends BaseMapper<TbOmExportHistory> {

    List<String> listDeployPackageUrl(@Param("dopsVersion") String dopsVersion, @Param("ptType")String ptType, @Param("pvVersion")String pvVersion);
}
