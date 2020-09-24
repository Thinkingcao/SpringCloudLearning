package com.example.order.controller;

import com.example.common.order.entity.Order;
import com.example.order.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:  订单服务
 * @author: cao_wencao
 * @date: 2020-09-22 23:27
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 用户购买下单，模拟全局事务提交
     * @param pid
     * @return
     */
    @RequestMapping("/purchase/commit/{pid}")
    public Order orderCommit(@PathVariable("pid") Integer pid) {
        return orderService.createOrderCommit(pid);
    }

    /**
     * 用户购买下单，模拟全局事务回滚
     * @param pid
     * @return
     */
    @RequestMapping("/purchase/rollback/{pid}")
    public Order orderRollback(@PathVariable("pid") Integer pid) {
        return orderService.createOrderRollback(pid);
    }

}