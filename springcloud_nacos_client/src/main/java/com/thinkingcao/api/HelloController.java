package com.thinkingcao.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 分布式配置中心自动刷新方式二
 * @auth: cao_wencao
 * @date: 2020-04-10 23:05
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/getServerPort")
    public String getServerPort(){
        String port = applicationContext.getEnvironment().getProperty("server.port");
        log.info("我的端口是===>>>: , {}", port);
        return port;
    }

}


