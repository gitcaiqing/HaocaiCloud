package com.haocai.ticketfront.cloudticketfront.controller.kd;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.ticketfront.cloudticketfront.service.ConfigFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/19 17:32
 **/
@Controller
@RequestMapping("/om/config")
public class ConfigController {

    @Autowired
    private ConfigFeignService configFeignService;

    @RequestMapping("/listPage")
    public String listPage() {
        return "config/list";
    }

    @RequestMapping(value="/listConfig", method = RequestMethod.GET)
    @ResponseBody
    public Object listDeployPackage(TbOmConfig omConfig, Page<TbOmConfig> page) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO(omConfig, page);
        Page<List> result = configFeignService.listConfig(pageRequestDTO);
        return result;
    }
}
