package com.thinkingcao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppMemberProvider {

    public static void main(String[] args) {
        SpringApplication.run(AppMemberProvider.class, args);
    }

}
