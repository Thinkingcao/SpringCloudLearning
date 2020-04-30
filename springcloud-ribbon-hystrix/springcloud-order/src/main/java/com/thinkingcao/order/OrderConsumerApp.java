package com.thinkingcao.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc:  订单服务-消费者
 * @author: cao_wencao
 * @date: 2020-04-29 17:50
 */
@SpringCloudApplication
@EnableFeignClients
public class OrderConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApp.class, args);
    }
}
