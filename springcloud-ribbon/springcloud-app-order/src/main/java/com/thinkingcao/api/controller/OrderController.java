package com.thinkingcao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:  订单调用会员服务接口
 * @author: cao_wencao
 * @date: 2020-02-19 17:47
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //订单服务(消费者)调用会员服务(生产者)接口
    @RequestMapping("/getOrderToMember")
    public String getOrderToMember() {
        String url = "http://app-thinkingcao-member/getMember";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    // 有两种方式调用，一种是采用服务别名方式调用，使用别名方式会去注册中心上获取对应的服务调用地址；
    // 另一种是直接使用IP地址调用(不会走注册中心)
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
