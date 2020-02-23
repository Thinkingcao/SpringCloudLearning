package com.thinkingcao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppMemerProvider {

    public static void main(String[] args) {
        SpringApplication.run(AppMemerProvider.class, args);
    }

}
