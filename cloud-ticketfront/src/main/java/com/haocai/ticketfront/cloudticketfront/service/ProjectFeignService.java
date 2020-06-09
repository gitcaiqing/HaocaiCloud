package com.haocai.ticketfront.cloudticketfront.service;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.impl.ProjectFeignServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/19 17:28
 **/
@FeignClient(value = "cloud-ticketserver", path = "/om/project", fallback = ProjectFeignServiceHystrix.class)
@Component
public interface ProjectFeignService {

    @RequestMapping(value="/listProject", method = RequestMethod.POST, consumes = "application/json")
    Page<List<OmProject>> listProject(@RequestBody PageRequestDTO<OmProjectPageDTO> pageRequestDTO);

    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    OmProject saveOrUpdate(@RequestBody OmProject omProject);

    @RequestMapping(value="/selectById")
    @ResponseBody
    ResponseMessage<OmProject> selectById(@RequestParam(value = "id") Long id);

    @RequestMapping(value="/deleteById")
    @ResponseBody
    OmProject deleteById(@RequestParam(value = "id") Long id);

    @RequestMapping(value="/getChartData", method = RequestMethod.POST)
    OmProjectChartVO getChartData(@RequestBody OmProjectPageDTO omProjectPageDTO);
}
