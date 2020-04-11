package com.thinkingcao.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 分布式配置中心自动刷新方式一
 * @auth: cao_wencao
 * @date: 2020/4/10 15:08
 */
@Slf4j
@RestController
@RefreshScope
public class NacosController {

    @Value("${user.name}")
    private String userName;


    @GetMapping("/getConfig")
    public String getConfig() {
        log.info("从nacos-server读取的数据=>>>>>： {}", userName);
        return userName;
    }


}
