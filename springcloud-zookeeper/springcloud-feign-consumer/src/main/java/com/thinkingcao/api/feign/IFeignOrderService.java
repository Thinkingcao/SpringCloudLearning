package com.thinkingcao.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:  服务消费者通过Feign HTTP客户端调用工具调用服务提供者提供的服务
 * @author: cao_wencao
 * @date: 2020-02-24 12:24
 */
@FeignClient("zk-member-provider")
public interface IFeignOrderService {

    //本地RPC调用会员接口
    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    public String getMember(@RequestParam("userName") String userName);

}
