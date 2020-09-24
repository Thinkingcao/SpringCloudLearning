package com.example.product.service;

import com.example.common.product.entity.Product;

/**
 * @desc:  商品接口
 * @author: cao_wencao
 * @date: 2020-09-22 23:18
 */
public interface ProductService {
    //根据pid查询商品信息
    Product findByPid(Integer pid);

    //扣减库存，正常->模拟全局事务提交
    void reduceInventoryCommit(Integer pid, Integer number);

    //扣减库存，异常->模拟全局事务回滚
    void reduceInventoryRollback(Integer pid, Integer number);
}
