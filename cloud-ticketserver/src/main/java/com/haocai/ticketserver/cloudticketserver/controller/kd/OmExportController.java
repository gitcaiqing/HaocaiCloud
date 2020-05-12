package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.ticketserver.cloudticketserver.service.OmExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 18:28
 **/
@Controller
public class OmExportController {

    @Autowired
    private OmExportService omExportService;

    /**
     * TODO
     * @param dopsVersion 海豚版本
     * @param ptType 所属项目类型
     * @param pvVersion 所属项目版本
     * @param zbType 坐标类型
     * @param dtType 数据类型
     * @return java.lang.String
     * @author CQ
     * @date 2020/5/12 19:59
     */
    @RequestMapping("/export")
    @ResponseBody
    public String export(@RequestParam(required = false) String dopsVersion,
                         @RequestParam(required = false) String ptType,
                         @RequestParam(required = false) String pvVersion,
                         @RequestParam(required = false) String zbType,
                         @RequestParam(required = false) String dtType){

        return omExportService.listAllResource(dopsVersion, ptType, pvVersion, zbType, dtType);
    }
}
