package com.thinkingcao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:   会员服务接口
 * @author: cao_wencao
 * @date: 2020-02-19 18:12
 */
@RestController
public class MemberController {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${server.port}")
    private String serverPort;

    //会员服务接口
    @RequestMapping("/getMember")
    private String getMember() {
        return "我是会员服务，订单服务调用会员服务成功啦, 端口号为： " + serverPort;
    }

    //会员调用支付接口
    @RequestMapping("/memberToPay")
    public String memberToPay(){
        String url = "http://app-thinkingcao-pay/doPay";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("会员服务调用支付服务result： "+ result);
        //制造空指针异常场景，被ZipKin发觉
       /* String str = null;
        if (str.equals("123aaa"))
        {

        }*/
        return result;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
