package com.haocai.order.Feign;

import com.haocai.base.cloudbase.vo.ResponseMessage;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/16 16:37
 **/
@FeignClient(value = "cloud-ticketserver", path = "/trans/tcc/amount")
//@FeignClient(value = "cloud-ticketserver", path = "/om/project", fallback = ProjectFeignServiceHystrix.class)
@Component
public interface TransTccAmountInfoFeignService {

    @RequestMapping("/transfer")
    @Hmily
    ResponseMessage transfer(@RequestParam("amount") Long amount);
}
