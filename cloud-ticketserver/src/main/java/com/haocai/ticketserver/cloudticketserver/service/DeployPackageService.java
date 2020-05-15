package com.haocai.ticketserver.cloudticketserver.service;

import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:16
 **/
public interface DeployPackageService {

    Page<List<TbOmDeployPackage>> listDeployPackage(TbOmDeployPackage omDeployPackage, Page<TbOmDeployPackage> page);

    TbOmDeployPackage insert(TbOmDeployPackage omDeployPackage);
}
