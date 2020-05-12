package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.entity.TbOmExportHistory;
import com.haocai.ticketserver.cloudticketserver.mapper.OmExportHistoryMapper;
import com.haocai.ticketserver.cloudticketserver.service.OmExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 18:31
 **/
@Service
@Transactional
public class OmExportServiceImpl extends ServiceImpl<OmExportHistoryMapper, TbOmExportHistory> implements OmExportService {

    @Autowired
    private OmExportHistoryMapper omExportHistoryMapper;

    @Override
    public String listAllResource(String dopsVersion, String ptType, String pvVersion, String zbType, String dtType) {

        //1.查询部署包
        List<String> deployPackageUrls = omExportHistoryMapper.listDeployPackageUrl(dopsVersion, ptType, pvVersion);

        //2.查询部署升级文件

        //3.查询数据文件
        StringBuilder content = new StringBuilder("");
        if(!CollectionUtils.isEmpty(deployPackageUrls)){
            content.append("部署包：").append("\n");
            for(String url: deployPackageUrls){
                content.append(url).append("\n");
            }
        }
        System.out.println(content.toString());
        return content.toString();
    }
}
