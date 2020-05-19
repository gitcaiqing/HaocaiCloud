package com.haocai.ticketserver.cloudticketserver.service;

import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:16
 **/
public interface OmConfigService {

    Page<List<TbOmConfig>> listConfig(TbOmConfig omConfig, Page<TbOmConfig> page);

    //TbOmConfig insert(TbOmConfig omDeployPackage);
}
