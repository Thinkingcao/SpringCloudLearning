package com.thinkingcao.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 提供给Consul健康检查的controller
 * @auth: cao_wencao
 * @date: 2020/2/23 0:08
 */
@RestController
public class HealthCheckController {

    //RequestMapping中的url地址需和配置文件中保持一致
    @RequestMapping("/health")
    public String healthCheck() {
        return "ok";
    }
}