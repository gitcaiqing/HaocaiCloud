package com.haocai.ticketserver.cloudticketserver.service.impl;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.enums.DeploymentStatusEnum;
import com.haocai.base.cloudbase.enums.ProjectTypeEnum;
import com.haocai.base.cloudbase.enums.StatusEnum;
import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.mapper.OmProjectMapper;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;
import com.haocai.ticketserver.cloudticketserver.service.OmProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/1 16:45
 **/
@Service
public class OmProjectServiceImpl implements OmProjectService {

    @Autowired
    private OmProjectMapper omProjectMapper;

    @Override
    public Page<List<OmProject>> listProject(OmProjectPageDTO omProjectPageDTO, Page<OmProjectPageDTO> reqPage) {
        int total = omProjectMapper.countData(omProjectPageDTO);
        if(total == 0) {
            return new Page<>(reqPage.getPage(), total, new ArrayList<>());
        }
        if(reqPage == null){
            reqPage = new Page<>();
        }
        List<OmProject> rows = omProjectMapper.listData(omProjectPageDTO, reqPage);
        return new Page<>(reqPage.getPage(), total, rows, reqPage.getPageSize(), reqPage.getSort(), reqPage.getOrder());
    }

    @Override
    public OmProject saveOrUpdate(OmProject omProject) {
        if(omProject == null){
            throw new BusinessException("项目不能为空");
        }
        Date now = new Date();
        if(omProject.getId() == null){
            omProject.setProjectUuid(UuidUtil.getUuid());
            omProject.setStatus(StatusEnum.A);
            omProject.setCreatedTime(now);
            //omProject.setCompleteTime(now);
            if(DeploymentStatusEnum.END.getValue().equals(omProject.getDeploymentStatus())
                //&& AcceptanceStatusEnum.ACCEPTED.getValue().equals(omProject.getAcceptanceStatus()))
            ){
                omProject.setCompleteTime(now);
            }
            omProjectMapper.insertSelective(omProject);
        }else{
            OmProject omProjectOld = omProjectMapper.selectByPrimaryKey(omProject.getId());
            if(omProjectOld == null){
                throw new BusinessException("项目不存在，更新失败");
            }
            omProject.setUpdatedTime(now);
            if(DeploymentStatusEnum.END.equals(omProject.getDeploymentStatus())
                    && !DeploymentStatusEnum.END.equals(omProjectOld.getDeploymentStatus())
                    //&& AcceptanceStatusEnum.ACCEPTED.equals(omProject.getAcceptanceStatus())
            ){
                omProject.setCompleteTime(now);
            }
            omProjectMapper.updateByPrimaryKeySelective(omProject);
        }
        return omProject;
    }

    @Override
    public OmProject selectById(Long id) {
        return omProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public OmProject deleteById(Long id) {
        OmProject omProject = omProjectMapper.selectByPrimaryKey(id);
        if(omProject == null){
            throw new RuntimeException("项目已不存在");
        }
        omProject = new OmProject();
        omProject.setStatus(StatusEnum.D);
        omProject.setId(id);
        omProjectMapper.updateByPrimaryKeySelective(omProject);
        return omProject;
    }

    @Override
    public OmProjectChartVO getChartData(OmProjectPageDTO omProjectPageDTO) {

        Integer ctServerTotals = 0;
        Integer kmapServerTotals = 0;
        Integer ctServerDeals = 0;
        Integer kmapServerDeals = 0;
        Integer ctServerDealing = 0;
        Integer kmapServerDealing = 0;

        List<OmProject> ctServerOmProjects = omProjectMapper.listByProjectType(omProjectPageDTO);
        if(!CollectionUtils.isEmpty(ctServerOmProjects)){
            for(OmProject omProject : ctServerOmProjects){
                if (ProjectTypeEnum.CTSERVER.getValue().equals(omProject.getProjectType())){
                    ctServerTotals++;
                    //部署中
                    if(DeploymentStatusEnum.START.equals(omProject.getDeploymentStatus())){
                        ctServerDealing++;
                    }else if(DeploymentStatusEnum.END.equals(omProject.getDeploymentStatus())){
                        ctServerDeals++;
                    }
                }else if(ProjectTypeEnum.KMAPSERVER.getValue().equals(omProject.getProjectType())){
                    kmapServerTotals++;
                    //部署中
                    if(DeploymentStatusEnum.START.equals(omProject.getDeploymentStatus())){
                        kmapServerDealing++;
                    }else if(DeploymentStatusEnum.END.equals(omProject.getDeploymentStatus())){
                        kmapServerDeals++;
                    }
                }
            }
        }
        List<Integer> totals = Arrays.asList(ctServerTotals, kmapServerTotals);
        List<Integer> deals = Arrays.asList(ctServerDeals, kmapServerDeals);
        List<Integer> dealing = Arrays.asList(ctServerDealing, kmapServerDealing);
        OmProjectChartVO vo = new OmProjectChartVO();
        vo.setTotals(totals);
        vo.setDeals(deals);
        vo.setDealings(dealing);
        return vo;
    }
}
