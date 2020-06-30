package com.thinkingcao.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @desc:   商品服务
 * @author: cao_wencao
 * @date: 2020-06-23 13:17
 */
@SpringBootApplication
@EnableEurekaClient
public class AppProduct{
    public static void main(String[] args) {
        SpringApplication.run(AppProduct.class,args);
    }
}
