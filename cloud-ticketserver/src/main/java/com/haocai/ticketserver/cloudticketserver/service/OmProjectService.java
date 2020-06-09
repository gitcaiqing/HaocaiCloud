package com.haocai.ticketserver.cloudticketserver.service;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:16
 **/
public interface OmProjectService {

    Page<List<OmProject>> listProject(OmProjectPageDTO omProjectPageDTO, Page<OmProjectPageDTO> page);

    OmProject saveOrUpdate(OmProject omProject);

    OmProject selectById(Long id);

    OmProject deleteById(Long id);

    OmProjectChartVO getChartData(OmProjectPageDTO omProjectPageDTO);

    //TbOmConfig insert(TbOmConfig omDeployPackage);
}
