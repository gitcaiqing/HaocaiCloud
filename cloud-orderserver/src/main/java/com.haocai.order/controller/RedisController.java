package com.haocai.order.controller;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.minlog.Log;
import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.config.RedisUtil;
import com.haocai.order.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Key;

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

    @Autowired
    private RedisService redisService;

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
    public ResponseMessage<BasicUser> getUser(){
        BasicUser basicUser = JSON.parseObject(redisUtil.get("basic").toString(), BasicUser.class);
        return ResponseMessage.ok(basicUser);
    }

    @RequestMapping("/get/{name}")
    @ResponseBody
    public ResponseMessage getName(@PathVariable(value = "name") String name){
        return ResponseMessage.ok(redisUtil.get(name));
    }

    /**
     * http://localhost:8400/redis/lock
     * @return
     */
    @RequestMapping("/lock")
    @ResponseBody
    public ResponseMessage testRedisLock(){
        for(int i=0; i<1; i++){

            new Thread(()->{
                String identifier = redisService.lockWithTimeout("resource", 5000, 5000);
                System.out.println(Thread.currentThread().getName()+"获取锁:"+identifier);
                redisService.releaseLock("resource", identifier);
            }).start();
        }

        return ResponseMessage.ok();
    }
}
