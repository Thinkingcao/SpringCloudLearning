package com.thinkingcao.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @desc:  Api Gateway网关
 * @author: cao_wencao
 * @date: 2020-06-23 13:07
 */
@SpringBootApplication
@EnableEurekaClient
public class AppGateway {
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }
}
