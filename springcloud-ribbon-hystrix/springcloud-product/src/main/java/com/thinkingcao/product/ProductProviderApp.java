package com.thinkingcao.product;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @desc:  商品服务-提供者
 * @author: cao_wencao
 * @date: 2020-04-29 17:48
 */
@SpringCloudApplication
public class ProductProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductProviderApp.class, args);
    }
}
