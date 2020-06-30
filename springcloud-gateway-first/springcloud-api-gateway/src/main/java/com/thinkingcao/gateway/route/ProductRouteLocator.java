package com.thinkingcao.gateway.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:  java写法路由配置
 * @author: cao_wencao
 * @date: 2020-06-30 14:28
 */
@Slf4j
@Configuration
public class ProductRouteLocator{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/product/**")
                        .uri("http://127.0.0.1:8016"))
                .build();
    }

}
