package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.mapper.OmConfigMapper;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.ticketserver.cloudticketserver.service.OmConfigService;
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
public class OmConfigServiceImpl implements OmConfigService {

    @Autowired
    private OmConfigMapper omConfigMapper;

    @Override
    public Page<List<TbOmConfig>> listConfig(TbOmConfig omConfig, Page<TbOmConfig> reqPage) {
        int total = omConfigMapper.countData(omConfig);
        if(total == 0) {
            return new Page<>(reqPage.getPage(), total, new ArrayList<>());
        }
        if(reqPage == null){
            reqPage = new Page<>();
        }
        List<TbOmConfig> rows = omConfigMapper.listData(omConfig, reqPage);
        return new Page<>(reqPage.getPage(), total, rows, reqPage.getPageSize(), reqPage.getSort(), reqPage.getOrder());
    }

    @Override
    public TbOmConfig saveOrUpdate(TbOmConfig omConfig) {
        if(omConfig == null){
            throw new RuntimeException();
        }
        if(omConfig.getId() == null){
            omConfig.setConfigUuid(UuidUtil.getUuid());
            omConfig.setStatus(StatusEnum.A);
            omConfig.setCreatedTime(new Date());
            Long id = omConfigMapper.insertSelective(omConfig);
            omConfig.setId(id);
        }else{
            omConfig.setUpdatedTime(new Date());
            omConfigMapper.updateByPrimaryKeySelective(omConfig);
        }
        return omConfig;
    }


}
