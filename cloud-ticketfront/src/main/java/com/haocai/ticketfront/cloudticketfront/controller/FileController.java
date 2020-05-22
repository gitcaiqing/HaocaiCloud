package com.haocai.ticketfront.cloudticketfront.controller;

import com.alibaba.fastjson.JSONObject;
import com.haocai.base.cloudbase.util.FileUtil;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/22 11:07
 **/
@Controller
@RequestMapping("/om/file")
@Slf4j
public class FileController {

    public final static String IMG_PATH_PREFIX = "ct_server_config_json/2_7_0/old/";

    @RequestMapping("/uploadFile")
    @ResponseBody
    public JSONObject fileUpload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        File fileOld = getImgDirFile();
        String fileUrl = fileOld.getAbsolutePath()+ "/" +fileName;
        File localFile = new File(fileUrl);
        try {
            file.transferTo(localFile);
        } catch (Exception e) {
            log.info("文件上传异常");
        }
        String content = FileUtil.readJsonFile(localFile);
        //content = IOUtils.toString(searchJson.getInputStream(), Charset.forName("UTF-8"));
        log.info("file content:{}", content);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileName", fileName);
        jsonObject.put("fileUrl", fileUrl);
        jsonObject.put("fileContent", content);
        return jsonObject;
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
