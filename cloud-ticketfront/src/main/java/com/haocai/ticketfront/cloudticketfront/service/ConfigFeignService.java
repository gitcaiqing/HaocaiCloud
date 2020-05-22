package com.haocai.ticketfront.cloudticketfront.service;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/19 17:28
 **/
@FeignClient(value = "cloud-ticketserver", path = "/om/config")
public interface ConfigFeignService {

    @RequestMapping(value="/listConfig", method = RequestMethod.POST, consumes = "application/json")
    Page<List<TbOmConfig>> listConfig(@RequestBody PageRequestDTO<TbOmConfig> pageRequestDTO);

    @RequestMapping(value="/om/config/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    TbOmConfig saveOrUpdate(@RequestBody TbOmConfig omConfig);
}
