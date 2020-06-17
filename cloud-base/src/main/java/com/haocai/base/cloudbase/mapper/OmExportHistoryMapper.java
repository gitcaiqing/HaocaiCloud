package com.haocai.base.cloudbase.mapper;


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

    List<String> listDeployPackageUrl(@Param("dolphinVersion") String dolphinVersion,
                                      @Param("projectType") String projectType,
                                      @Param("projectVersion") String projectVersion);

    List<String> listDeployFileUrl(@Param("projectType") String projectType);

    List<String> listCtServerDeployDataUrl(@Param("projectType") String projectType, @Param("zbType") String zbType,
                                           @Param("dataType") String dataType,
                                           @Param("dataTypeRegionAndRiver") String dataTypeRegionAndRiver,
                                           @Param("dataTypeCommon") String dataTypeCommon);

    List<String> listDeployDataUrl(@Param("projectType") String projectType, @Param("zbType") String zbType,
                                   @Param("dataType") String dataType);
}
