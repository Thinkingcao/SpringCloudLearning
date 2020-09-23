package com.thinkingcao.nacos.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:    生产者——>商品服务
 * @author: cao_wencao
 * @date: 2020-04-17 20:58
 */
@Slf4j
@RestController
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        log.info("开始调用商品服务信息啦");
        return "我是商品服务, 调用商品服务接口成功了===>> : " + port;
    }

}
