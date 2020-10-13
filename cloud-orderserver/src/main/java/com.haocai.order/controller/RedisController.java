package com.haocai.order.controller;

import com.alibaba.fastjson.JSON;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/9/15 13:13
 **/
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    @ResponseBody
    public ResponseMessage<String> set(){
        BasicUser basicUser = new BasicUser();
        basicUser.setAge(19);
        redisUtil.set("basic",JSON.toJSONString(basicUser));
        redisUtil.set("name", JSON.toJSONString("cai"));
        return ResponseMessage.ok("普通缓存放入");
    }

    @RequestMapping("/get/basic")
    @ResponseBody
    public ResponseMessage<Object> getUser(){
        BasicUser basicUser = JSON.parseObject(redisUtil.get("basic").toString(), BasicUser.class);
        return ResponseMessage.ok(basicUser);
    }

    @RequestMapping("/get/name")
    @ResponseBody
    public ResponseMessage<Object> getName(){
        return ResponseMessage.ok(redisUtil.get("name").toString());
    }
}
