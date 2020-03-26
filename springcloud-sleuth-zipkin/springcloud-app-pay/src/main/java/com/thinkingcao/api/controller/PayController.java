package com.thinkingcao.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 支付服务接口
 * @author: cao_wencao
 * @date: 2020-03-26 13:32
 */
@RestController
public class PayController {

    @RequestMapping("/doPay")
    public String doPay() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "我支付服务哦，准备开始执行支付操作啦";
    }

}
