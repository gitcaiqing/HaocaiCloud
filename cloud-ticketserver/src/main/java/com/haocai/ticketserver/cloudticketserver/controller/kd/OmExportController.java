package com.haocai.ticketserver.cloudticketserver.controller.kd;

import com.haocai.base.cloudbase.vo.ResponseMessage;
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
     * http://localhost:8300/export?dolphinVersion=&projectType=KMAPSERVER&projectVersion=&zbType=&dataType=
     * http://localhost:8300/export?dolphinVersion=2.2&projectType=KMAPSERVER&projectVersion=1.0&zbType=GCJ02&dataType=320000
     * @param dolphinVersion 海豚版本
     * @param projectType 所属项目类型
     * @param projectVersion 所属项目版本
     * @param zbType 坐标类型
     * @param dataType 数据类型
     * @return java.lang.String
     * @author CQ
     * @date 2020/5/12 19:59
     */
    @RequestMapping("/export")
    @ResponseBody
    public String export(@RequestParam(required = false) String dolphinVersion,
                                  @RequestParam(required = false) String projectType,
                                  @RequestParam(required = false) String projectVersion,
                                  @RequestParam(required = false) String zbType,
                                  @RequestParam(required = false) String dataType){
        return omExportService.listAllResource(dolphinVersion, projectType, projectVersion, zbType, dataType);
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate(){
        return omExportService.validate();
    }
}
