package com.thinkingcao.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:   生产者-商品服务
 * @author: cao_wencao
 * @date: 2020-04-29 19:48
 */
@RestController
public class ProviderController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}
