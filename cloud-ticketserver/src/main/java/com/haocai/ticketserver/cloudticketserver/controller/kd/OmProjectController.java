package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.Exception.BusinessException;
import com.haocai.ticketserver.cloudticketserver.service.OmConfigService;
import com.haocai.ticketserver.cloudticketserver.service.OmProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 11:22
 **/
@Controller
@RequestMapping("/om/project")
@Slf4j
public class OmProjectController {

    @Autowired
    private OmProjectService omProjectService;

    @RequestMapping(value="/listProject", method = RequestMethod.POST)
    @ResponseBody
    public Page<List<OmProject>> listProject(@RequestBody(required = false) PageRequestDTO<OmProjectPageDTO> pageRequestDTO) {
        log.info("请求参数:{}", pageRequestDTO);
        return omProjectService.listProject(pageRequestDTO.getBean(), pageRequestDTO.getPage());
    }

    @RequestMapping(value="/getChartData", method = RequestMethod.POST)
    @ResponseBody
    public OmProjectChartVO getChartData(@RequestBody OmProjectPageDTO omProjectPageDTO){
        log.info("请求参数:{}", omProjectPageDTO.toString());
        return omProjectService.getChartData(omProjectPageDTO);
    }

    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public OmProject saveOrUpdate(@RequestBody OmProject omProject){
        return omProjectService.saveOrUpdate(omProject);
    }

    @RequestMapping(value="/selectById")
    @ResponseBody
    public ResponseMessage<OmProject> selectById(@RequestParam(value = "id") Long id){
        OmProject omProject = omProjectService.selectById(id);
        if(omProject == null){
            throw new BusinessException("项目不存在");
        }
        return ResponseMessage.ok(omProjectService.selectById(id));
    }

    @RequestMapping(value="/deleteById")
    @ResponseBody
    public OmProject deleteById(@RequestParam(value = "id") Long id){
        return omProjectService.deleteById(id);
    }
}
