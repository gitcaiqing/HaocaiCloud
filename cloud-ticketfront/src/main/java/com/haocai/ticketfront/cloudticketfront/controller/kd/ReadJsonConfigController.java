package com.haocai.ticketfront.cloudticketfront.controller.kd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmDeployPackage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/19 13:52
 **/
@Controller
@RequestMapping("/om/readConfig")
public class ReadJsonConfigController {

    @Value("classpath:json/2_7_0/kfront-ctserver-search-server-1.0.0-config.json")
    private Resource searchJson;

    public final static String IMG_PATH_PREFIX = "ct_server_config_json/2_7_0/new/";

    @RequestMapping(value="/search", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listDeployPackage(TbOmDeployPackage omDeployPackage, Page<TbOmDeployPackage> page) {

        String filePath = "D:\\CTSERVER\\2_7_0\\20200519\\";
        String fileName = "kfront-ctserver-search-server-1.0.0-config.json";
        String content = null;
        try {
            content = IOUtils.toString(searchJson.getInputStream(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean flag = addCodeToTxt(filePath, fileName, content);
        System.out.println(flag);
        /*try {
            String searchStr = IOUtils.toString(searchJson.getInputStream(), Charset.forName("UTF-8"));
            return (JSONObject)JSON.parse(searchStr);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return (JSONObject)JSON.parse(content);
    }

    public boolean addCodeToTxt(String filePath,String filename, String content){

        // 文件路径 D\:\shorturl\cpdm\时间戳\
        // 创建文件夹
        // 创建文件夹
        //File file = new File(filePath);
        File file = getImgDirFile();
        // 输出文件夹绝对路径 – 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(file.getAbsolutePath());
        boolean mkdirsFlag = true;
        if(!file.exists()){
            mkdirsFlag = file.mkdirs();
        }
        // 创建文件
        //File fileTxt = new File(filePath+filename);
        File fileTxt = new File(file.getAbsolutePath() +"/"+filename);
        System.out.println(fileTxt.getAbsolutePath());
        if(!fileTxt.exists()){
            try {
                fileTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileTxt, true);
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            filePath = null;
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    filePath = null;
                }
            }
        }
        return mkdirsFlag;
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

