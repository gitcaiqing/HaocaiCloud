package com.haocai.base.cloudbase.mapper;

import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:18
 **/
@Repository
public interface OmDeployPackageMapper {

    int countData(@Param("omDeployPackage") TbOmDeployPackage omDeployPackage);

    List<TbOmDeployPackage> listData(@Param("omDeployPackage") TbOmDeployPackage omDeployPackage, @Param("page") Page<TbOmDeployPackage> page);

    Long insertSelective(TbOmDeployPackage omDeployPackage);
}
