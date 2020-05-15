package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.ticketserver.cloudticketserver.mapper.OmDeployPackageMapper;
import com.haocai.ticketserver.cloudticketserver.service.DeployPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:16
 **/
@Service
public class OmDeployPackageServiceImpl implements DeployPackageService {

    @Autowired
    private OmDeployPackageMapper omDeployPackageMapper;

    @Override
    public Page<List<TbOmDeployPackage>> listDeployPackage(TbOmDeployPackage omDeployPackage, Page<TbOmDeployPackage> reqPage) {
        int total = omDeployPackageMapper.countData(omDeployPackage);
        if(total == 0) {
            return new Page<>(reqPage.getPage(), total, new ArrayList<>());
        }
        if(reqPage == null){
            reqPage = new Page<>();
        }
        List<TbOmDeployPackage> rows = omDeployPackageMapper.listData(omDeployPackage, reqPage);
        return new Page<>(reqPage.getPage(), total, rows, reqPage.getPageSize(), reqPage.getSort(), reqPage.getOrder());
    }

    @Override
    public TbOmDeployPackage insert(TbOmDeployPackage omDeployPackage) {
        if(omDeployPackage == null){
            throw new RuntimeException();
        }
        omDeployPackage.setPackageUuid(UuidUtil.getUuid());
        omDeployPackage.setUrlExpired(StatusEnum.A);
        omDeployPackage.setStatus(StatusEnum.A);
        omDeployPackage.setCreatedTime(new Date());
        omDeployPackageMapper.insertSelective(omDeployPackage);
        return omDeployPackage;
    }
}
