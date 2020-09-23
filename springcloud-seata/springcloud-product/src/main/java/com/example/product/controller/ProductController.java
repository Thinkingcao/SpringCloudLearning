package com.example.product.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.entity.Product;
import com.example.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:16
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    //扣减库存
    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(Integer pid, Integer number) {
        productService.reduceInventory(pid, number);
    }

    //商品信息查询
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}
