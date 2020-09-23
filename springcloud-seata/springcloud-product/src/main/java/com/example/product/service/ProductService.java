package com.example.product.service;

import com.example.common.product.entity.Product;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:18
 */
public interface ProductService {
    //根据pid查询商品信息
    Product findByPid(Integer pid);

    //扣减库存
    void reduceInventory(Integer pid, Integer number);
}
