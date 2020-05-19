package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.PageResult;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.DeployPackageService;
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
public class OmDeployPackageController {

    @Autowired
    private DeployPackageService deployPackageService;

    @RequestMapping(value="/om/deployPackage/listDeployPackage", method = RequestMethod.POST)
    @ResponseBody
    public Page<List<TbOmDeployPackage>> listDeployPackage(@RequestBody(required = false) PageRequestDTO<TbOmDeployPackage> pageRequestDTO) {
        return deployPackageService.listDeployPackage(pageRequestDTO.getBean(), pageRequestDTO.getPage());
    }

    @RequestMapping(value="/om/deployPackage/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage insert(@RequestBody(required = false) TbOmDeployPackage omDeployPackage){
        return ResponseMessage.ok(deployPackageService.insert(omDeployPackage));
    }
}
