package com.haocai.ticketfront.cloudticketfront.service;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/14 14:14
 **/
@FeignClient(value = "cloud-ticketserver", path = "/om/deployPackage")
public interface DeployPackageFeignService {

    @RequestMapping(value="/listDeployPackage", method = RequestMethod.POST, consumes = "application/json")
    Page<List<TbOmDeployPackage>> listDeployPackage(@RequestBody PageRequestDTO<TbOmDeployPackage> pageRequestDTO);

    @RequestMapping(value="/insert", method = RequestMethod.POST, consumes = "application/json")
    ResponseMessage insert(@RequestBody TbOmDeployPackage omDeployPackage);
}
