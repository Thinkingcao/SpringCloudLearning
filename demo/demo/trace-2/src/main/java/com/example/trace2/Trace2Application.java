package com.example.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/10 14:48
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Trace2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

}
