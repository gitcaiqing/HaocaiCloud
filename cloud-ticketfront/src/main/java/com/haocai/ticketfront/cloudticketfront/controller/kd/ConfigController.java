package com.haocai.ticketfront.cloudticketfront.controller.kd;

import com.haocai.base.cloudbase.dto.PageRequestDTO;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.ticketfront.cloudticketfront.service.ConfigFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public final static String IMG_PATH_PREFIX = "ct_server_config_json/2_7_0/old/";

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

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public Object edit() {
        return "config/configEdit";
    }

    @RequestMapping(value="/saveOrUpdate")
    @ResponseBody
    public ResponseMessage saveOrUpdate(@RequestBody TbOmConfig omConfig) {
        omConfig = configFeignService.saveOrUpdate(omConfig);
        return ResponseMessage.ok(omConfig);
    }

    public static File getImgDirFile(){
        // 构建上传文件的存放 “文件夹” 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
