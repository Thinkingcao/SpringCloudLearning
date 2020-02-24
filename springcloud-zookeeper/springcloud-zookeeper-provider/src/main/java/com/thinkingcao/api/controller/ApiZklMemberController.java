package com.thinkingcao.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:  服务生产者(会员服务)
 * @author: cao_wencao
 * @date: 2020-02-22 23:44
 */
@RestController
public class ApiZklMemberController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/getMember", method = RequestMethod.GET)
    private String getMember(@RequestParam("userName") String userName){
        return "我是会员服务，订单服务调用会员服务成功啦, 姓名为： " + userName + ", 端口为： " + serverPort;
    }

}
