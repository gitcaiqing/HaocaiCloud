package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketserver.cloudticketserver.service.DeployPackageService;
import com.haocai.ticketserver.cloudticketserver.service.OmConfigService;
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
public class OmConfigController {

    @Autowired
    private OmConfigService omConfigService;

    @RequestMapping(value="/om/config/listConfig", method = RequestMethod.POST)
    @ResponseBody
    public Page<List<TbOmConfig>> listDeployPackage(@RequestBody(required = false) PageRequestDTO<TbOmConfig> pageRequestDTO) {
        return omConfigService.listConfig(pageRequestDTO.getBean(), pageRequestDTO.getPage());
    }

    @RequestMapping(value="/om/config/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public TbOmConfig saveOrUpdate(@RequestBody TbOmConfig omConfig){
        return omConfigService.saveOrUpdate(omConfig);
    }
}
