package com.example.springcloudorder.controller;

import com.example.common.entity.Order;
import com.example.springcloudorder.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:27
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        return orderService.createOrder(pid);
    }

}