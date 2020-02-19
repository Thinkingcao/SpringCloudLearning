package com.thinkingcao.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-19 18:12
 */
@RestController
public class MemberController {

    @RequestMapping("/getMember")
    private String getMember() {
        return "我是会员服务，订单服务调用会员服务成功啦";
    }
}
