package com.haocai.ticketfront.cloudticketfront.controller.kd;

import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.enums.CodeEnum;
import com.haocai.base.cloudbase.enums.ResponseStatusEnum;
import com.haocai.base.cloudbase.util.TimeUtil;
import com.haocai.base.cloudbase.util.ValidUtil;
import com.haocai.base.cloudbase.vo.OmProjectChartVO;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.ProjectFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/19 17:32
 **/
@Controller
@RequestMapping("/om/project")
public class ProjectController {

    @Autowired
    private ProjectFeignService projectFeignService;

    @RequestMapping("/listPage")
    public String listPage(Model model, OmProject project) {
        model.addAttribute("project", project);
        return "project/list";
    }

    @RequestMapping(value="/listProject", method = RequestMethod.GET)
    @ResponseBody
    public Object listDeployPackage(OmProjectPageDTO omProjectPageDTO, Page<OmProjectPageDTO> page) {
        if(Objects.nonNull(omProjectPageDTO.getCreatedTimeEnd())){
            omProjectPageDTO.setCreatedTimeEnd(TimeUtil.getOtherDay(omProjectPageDTO.getCreatedTimeEnd(), 1));
        }
        if(Objects.nonNull(omProjectPageDTO.getCompleteTimeEnd())){
            omProjectPageDTO.setCompleteTimeEnd(TimeUtil.getOtherDay(omProjectPageDTO.getCompleteTimeEnd(), 1));
        }
        page.setSort("work_id");page.setOrder("desc");
        PageRequestDTO pageRequestDTO = new PageRequestDTO(omProjectPageDTO, page);
        Page<List> result = projectFeignService.listProject(pageRequestDTO);
        return result;
    }

    @RequestMapping(value="/getChartData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getChartData(OmProjectPageDTO omProjectPageDTO) {
        if(Objects.nonNull(omProjectPageDTO.getCreatedTimeEnd())){
            omProjectPageDTO.setCreatedTimeEnd(TimeUtil.getOtherDay(omProjectPageDTO.getCreatedTimeEnd(), 1));
        }
        if(Objects.nonNull(omProjectPageDTO.getCompleteTimeEnd())){
            omProjectPageDTO.setCompleteTimeEnd(TimeUtil.getOtherDay(omProjectPageDTO.getCompleteTimeEnd(), 1));
        }
        OmProjectChartVO vo = projectFeignService.getChartData(omProjectPageDTO);
        System.out.println(vo);
        /*OmProjectChartVO vo = new OmProjectChartVO();
        vo.setTotals(Arrays.asList(50,30));
        vo.setDeals(Arrays.asList(20,10));
        vo.setDealings(Arrays.asList(30,20));*/
        return ResponseMessage.ok(vo);
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public Object edit(@RequestParam("id")Long id, Model model) {
        if(id != null && id != 0){
            ResponseMessage<OmProject> res = projectFeignService.selectById(id);
            if(ValidUtil.requestSuccess(res)){
                model.addAttribute("project", res.getResult());
            }
        }
        return "project/projectEdit";
    }


    /**
     * 获详情
     * @param id
     * @return
     */
    @RequestMapping(value="/getProjectById/{id}", method = RequestMethod.GET)
    public String getBasicUserById(@PathVariable("id")Long id, Model model) {
        if(id != null){
            ResponseMessage<OmProject> res = projectFeignService.selectById(id);
            if(ValidUtil.requestSuccess(res)){
                model.addAttribute("project", res.getResult());
            }
        }
        return "project/projectDetail";
    }


    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage saveOrUpdate(@RequestBody OmProject omProject) {
        omProject = projectFeignService.saveOrUpdate(omProject);
        return ResponseMessage.ok(omProject);
    }

    @RequestMapping(value="/deleteById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage deleteById(@PathVariable("id")Long id) {
        OmProject omProject = projectFeignService.deleteById(id);
        return ResponseMessage.ok(omProject);
    }
}
