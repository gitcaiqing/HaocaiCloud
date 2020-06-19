package com.haocai.order.controller;

import com.haocai.base.cloudbase.vo.ResponseMessage;
import com.haocai.order.service.TransOfSpringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/19 11:28
 **/
@Controller
@RequestMapping("/trans/spring")
@Slf4j
public class TransOfSpringController {

    @Autowired
    private TransOfSpringService transOfSpringService;

    //事务传播行为测试↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationRequired
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:36
     */
    @RequestMapping("/testPropagationRequired")
    @ResponseBody
    public ResponseMessage testPropagationRequired(){
        transOfSpringService.testPropagationRequired();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationSupports
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:36
     */
    @RequestMapping("/testPropagationSupports")
    @ResponseBody
    public ResponseMessage testPropagationSupports(){
        transOfSpringService.testPropagationSupports();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationMandatory
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:37
     */
    @RequestMapping("/testPropagationMandatory")
    @ResponseBody
    public ResponseMessage testPropagationMandatory(){
        transOfSpringService.testPropagationMandatory();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationRequireNew
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:37
     */
    @RequestMapping("/testPropagationRequireNew")
    @ResponseBody
    public ResponseMessage testPropagationRequireNew(){
        transOfSpringService.testPropagationRequireNew();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationNotSupported
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:37
     */
    @RequestMapping("/testPropagationNotSupported")
    @ResponseBody
    public ResponseMessage testPropagationNotSupported(){
        transOfSpringService.testPropagationNotSupported();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationNever
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:37
     */
    @RequestMapping("/testPropagationNever")
    @ResponseBody
    public ResponseMessage testPropagationNever(){
        transOfSpringService.testPropagationNever();
        return ResponseMessage.ok();
    }

    /**
     * TODO
     * http://localhost:8400/trans/spring/testPropagationNested
     * @param
     * @return com.haocai.base.cloudbase.vo.ResponseMessage
     * @author CQ
     * @date 2020/6/19 11:37
     */
    @RequestMapping("/testPropagationNested")
    @ResponseBody
    public ResponseMessage testPropagationNested(){
        transOfSpringService.testPropagationNested();
        return ResponseMessage.ok();
    }
}
