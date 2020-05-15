package com.haocai.ticketfront.cloudticketfront.controller.kd;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.DeployPackageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 11:22
 **/
@Controller
@RequestMapping("/om/deployPackage")
public class DeployPackageController {

    @Autowired
    private DeployPackageFeignService deployPackageFeignService;

    @RequestMapping("/listPage")
    public String listPage() {
        return "deployPackage/list";
    }

    @RequestMapping(value="/listDeployPackage", method = RequestMethod.GET)
    @ResponseBody
    public Object listDeployPackage(TbOmDeployPackage omDeployPackage, Page<TbOmDeployPackage> page) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO(omDeployPackage, page);
        Page<List<TbOmDeployPackage>> result = deployPackageFeignService.listDeployPackage(pageRequestDTO);
        return result;
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<TbOmDeployPackage> listDeployPackage(@RequestBody TbOmDeployPackage omDeployPackage) {
        ResponseMessage responseMessage = deployPackageFeignService.insert(omDeployPackage);
        return responseMessage;
    }
}
