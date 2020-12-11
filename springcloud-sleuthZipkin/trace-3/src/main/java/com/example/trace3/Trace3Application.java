package com.example.trace3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/11 9:47
 */
@EnableEurekaClient
@SpringBootApplication
public class Trace3Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace3Application.class, args);
    }

}
