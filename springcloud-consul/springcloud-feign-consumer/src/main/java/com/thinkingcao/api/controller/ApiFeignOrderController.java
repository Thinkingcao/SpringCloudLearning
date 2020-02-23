package com.thinkingcao.api.controller;

import com.thinkingcao.api.Feign.IFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:  服务消费者(订单服务)
 * @author: cao_wencao
 * @date: 2020-02-22 12:30
 */
@RestController
public class ApiFeignOrderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    // @Autowired
    // private OrderService orderService;

    @Autowired(required = false)
    private IFeignClientService feignClientService;


    @RequestMapping(value ="/getMemberInfo",method = RequestMethod.GET)
    public String getMemberInfo(@RequestParam("userName") String userName) {
        String memberInfo = feignClientService.getOrderToMemberInfo(userName);
        return memberInfo;
    }


    @RequestMapping(value = "/discover",method = RequestMethod.GET)
    public String discover(){
        String instance = loadBalancerClient.choose("member-provider").getUri().toString();
        return instance;
    }

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("member-provider");
    }

}
