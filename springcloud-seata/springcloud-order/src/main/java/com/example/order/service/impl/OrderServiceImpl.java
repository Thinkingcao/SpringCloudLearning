package com.example.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.common.order.entity.Order;
import com.example.common.product.entity.Product;
import com.example.order.dao.OrderDao;
import com.example.order.feign.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:30
 */
@Service
@Slf4j
public class OrderServiceImpl {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductService productService;


    @GlobalTransactional//全局事务控制
    public Order createOrder(Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);

        //1 调用商品微服务,查询商品信息
        Product product = productService.findByPid(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));

        //2 下单(创建订单)
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));

        //3 扣库存m
        productService.reduceInventory(pid, order.getNumber());

        return order;
    }

}
