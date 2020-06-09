package com.haocai.ticketfront.cloudticketfront.service.impl;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.ProjectFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/9 14:51
 **/
@Component
public class ProjectFeignServiceHystrix implements ProjectFeignService {

    @Override
    public Page<List<OmProject>> listProject(PageRequestDTO<OmProjectPageDTO> pageRequestDTO) {
        return null;
    }

    @Override
    public OmProject saveOrUpdate(OmProject omProject) {
        return null;
    }

    @Override
    public ResponseMessage<OmProject> selectById(Long id) {
        return null;
    }

    @Override
    public OmProject deleteById(Long id) {
        return null;
    }

    @Override
    public OmProjectChartVO getChartData(OmProjectPageDTO omProjectPageDTO) {
        return null;
    }
}
