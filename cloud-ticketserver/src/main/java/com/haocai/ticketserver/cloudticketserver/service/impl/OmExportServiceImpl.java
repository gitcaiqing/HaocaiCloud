package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.entity.TbOmExportHistory;
import com.haocai.base.cloudbase.enums.DataTypeEnum;
import com.haocai.base.cloudbase.enums.ProjectTypeEnum;
import com.haocai.base.cloudbase.mapper.OmExportHistoryMapper;
import com.haocai.base.cloudbase.util.HttpConnUtil;
import com.haocai.ticketserver.cloudticketserver.service.OmExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    /**
     * TODO
     * @param dolphinVersion 海豚版本
     * @param projectType 所属项目类型
     * @param projectVersion 所属项目版本
     * @param zbType 坐标类型
     * @param dataType 数据类型
     * @return java.lang.String
     * @author CQ
     * @date 2020/5/13 10:52
     */
    @Override
    public String listAllResource(String dolphinVersion, String projectType, String projectVersion, String zbType, String dataType) {

        //1.查询部署包
        //根据海豚版本、项目类型、项目版本获取部署包
        List<String> deployPackageUrls = new ArrayList<>();
        if(ProjectTypeEnum.CTSERVER.toString().equals(projectType)){
            deployPackageUrls = omExportHistoryMapper.listDeployPackageUrl(dolphinVersion, projectType, projectVersion);

        }else if(ProjectTypeEnum.KMAPSERVER.toString().equals(projectType)){
            deployPackageUrls = omExportHistoryMapper.listDeployPackageUrl(null, projectType, projectVersion);
        }

        //2.查询部署升级文件
        //根据项目类型获取部署升级文件
        List<String> deployFileUrls = omExportHistoryMapper.listDeployFileUrl(projectType);

        //3.查询数据文件
        //项目类型获取
        List<String> deployDataUrls = new ArrayList<>();
        if(ProjectTypeEnum.CTSERVER.toString().equals(projectType)){
            deployDataUrls = omExportHistoryMapper.listCtServerDeployDataUrl(projectType, zbType, dataType, DataTypeEnum.REGIONRIVER.toString(), DataTypeEnum.COMMON.toString());

        }else if(ProjectTypeEnum.KMAPSERVER.toString().equals(projectType)){
            deployDataUrls = omExportHistoryMapper.listDeployDataUrl(projectType, zbType, dataType);
        }

        StringBuilder content = new StringBuilder();
        content.append("部署包：").append("\n");
        if(!CollectionUtils.isEmpty(deployPackageUrls)){

            for(String url: deployPackageUrls){
                content.append(url).append("\n");
            }
        }
        content.append("部署文件：").append("\n");
        if(!CollectionUtils.isEmpty(deployFileUrls)){

            for(String url: deployFileUrls){
                content.append(url).append("\n");
            }
        }
        content.append("数据文件：").append("\n");
        if(!CollectionUtils.isEmpty(deployDataUrls)){

            for(String url: deployDataUrls){
                content.append(url).append("\n");
            }
        }
        System.out.println(content.toString());
        return content.toString();
    }

    @Override
    public String validate() {
        String url = "https://yunpan.kedacom.com/d/69900b1809d34af9b186/";
        String result = HttpConnUtil.sendGet(url, null ,0, 0);
        return result;
    }
}

