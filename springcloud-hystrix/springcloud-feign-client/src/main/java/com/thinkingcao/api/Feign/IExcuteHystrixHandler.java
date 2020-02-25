package com.thinkingcao.api.Feign;

import com.thinkingcao.api.service.impl.GetHystrixResultImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc:   接口形式配置Hystrix，fallback服务出现熔断时，需要降级到此回调方法，响应给用户
 * @author: cao_wencao
 * @date: 2020-02-25 12:53
 */
@FeignClient(value = "app-thinkingcao-member",fallback = GetHystrixResultImpl.class)
public interface IExcuteHystrixHandler {

    //获取Hystrix降级熔断执行回调方法的结果
    @RequestMapping("/excuteHystrixHandler")
    public String getHystrixInfo();

}
