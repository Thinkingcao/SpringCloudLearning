package com.thinkingcao.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thinkingcao.api.Feign.IFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-22 12:30
 */
@RestController
public class ApiOrderController {

    @Autowired(required=false)
    private IFeignClientService feignClientService;


    //没有服务雪崩效应
    @RequestMapping(value = "/getOrderToMemberInfoNoHystrix",method = RequestMethod.GET)
    public String getOrderToMemberInfoNoHystrix(@RequestParam("userName") String userName){
        String memberInfo = feignClientService.getOrderToMemberInfo(userName);
        return memberInfo;
    }


    //解决服务雪崩效应
    @HystrixCommand(fallbackMethod= "excuteHystrixHandle")
    @RequestMapping(value = "/getOrderToMemberInfoForHystrix",method = RequestMethod.GET)
    public String getOrderToMemberInfoForHystrix(@RequestParam("userName") String userName){
        String memberInfo = feignClientService.getOrderToMemberInfo(userName);
        return memberInfo;
    }


    //服务进入保护时，回调方法
    public String excuteHystrixHandle(String userName) {
        return  userName+"您好，当前系统人数较多，请稍后重试，给您带来的不便，敬请谅解！！！";
    }


}
