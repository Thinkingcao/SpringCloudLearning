package com.example.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:29
 */
@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//订单id

    //用户
    private Integer uid;//用户id
    private String username;//用户名

    //商品
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价

    //数量
    private Integer number;//购买数量
}