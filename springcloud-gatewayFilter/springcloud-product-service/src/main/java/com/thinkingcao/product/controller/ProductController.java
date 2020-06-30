package com.thinkingcao.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:   商品服务
 * @author: cao_wencao
 * @date: 2020-06-28 10:34
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/getProductInfo")
    public Map<String,String> getProductInfo(){
        Map<String,String> productsMap = new HashMap<>();
        productsMap.put("productNo","111");
        productsMap.put("productName","荔枝");
        productsMap.put("productDesc","一骑红尘妃子笑，无人知是荔枝来");
        productsMap.put("productPrice","11.0");
        productsMap.put("productWeight","10.0");
        return productsMap;
    }
}
