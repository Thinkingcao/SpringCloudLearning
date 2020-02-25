package com.thinkingcao.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:   会员服务接口
 * @author: cao_wencao
 * @date: 2020-02-19 18:12
 */
@RestController
public class MemberController {

    @Value("${server.port}")
    private String serverPort;

    //会员服务接口
    @RequestMapping("/getMember")
    private String getMember(@RequestParam("userName") String userName) {
        return "我是会员服务，订单服务调用会员服务成功啦, 端口号为： " + serverPort +"——用户名： "+ userName;
    }


    @RequestMapping("/excuteHystrixHandler")
    private String excuteHystrixHandler(){
        return "您好，当前系统人数较多，请稍后重试，给您带来的不便，敬请谅解！！！";
    }

}
