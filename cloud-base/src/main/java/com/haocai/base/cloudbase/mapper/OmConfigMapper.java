package com.haocai.base.cloudbase.mapper;

import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:18
 **/
@Repository
public interface OmConfigMapper {

    int countData(@Param("omConfig") TbOmConfig omConfig);

    List<TbOmConfig> listData(@Param("omConfig") TbOmConfig omConfig, @Param("page") Page<TbOmConfig> page);

    Long insertSelective(TbOmConfig omConfig);

    int updateByPrimaryKeySelective(TbOmConfig omConfig);

    //Long insertSelective(TbOmDeployPackage omDeployPackage);
}
