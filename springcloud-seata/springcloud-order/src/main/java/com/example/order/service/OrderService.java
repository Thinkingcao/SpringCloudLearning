package com.example.order.service;

import com.example.common.order.entity.Order;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:29
 */
public interface OrderService {
    //创建订单
    void createOrder(Order order);
}
