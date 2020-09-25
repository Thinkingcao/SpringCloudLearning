package com.example.product.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.product.entity.Product;
import com.example.common.utils.ServletUtils;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 扣减库存，正常->模拟全局事务提交
     * @param pid
     * @param number
     */
    @RequestMapping("/reduceInventory/commit")
    public void reduceInventoryCommit(Integer pid, Integer number) {
        String token = ServletUtils.getRequest().getHeader("token");
        log.info("从head请求头透传过来的值为token："+ token);
        productService.reduceInventoryCommit(pid, number);
    }

    /**
     * 扣减库存，异常->模拟全局事务回滚
     * @param pid
     * @param number
     */
    @RequestMapping("/reduceInventory/rollback")
    public void reduceInventoryRollback(Integer pid, Integer number) {
        productService.reduceInventoryRollback(pid, number);
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
