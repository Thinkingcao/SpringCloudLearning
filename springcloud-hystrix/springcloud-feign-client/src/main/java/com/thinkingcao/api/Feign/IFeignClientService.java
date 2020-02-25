package com.thinkingcao.api.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: Feign声明式客户端调用工具，非接口形式配置Hystrix
 * @author: cao_wencao
 * @date: 2020-02-22 12:23
 */
@FeignClient(value = "app-thinkingcao-member")
public interface IFeignClientService {

    //通过userId查询会员信息数据
    @RequestMapping("/getMember")
    public String getOrderToMemberInfo(@RequestParam("userName") String userName);

}
