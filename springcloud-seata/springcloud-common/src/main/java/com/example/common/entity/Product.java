package com.example.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:18
 */
//商品
@Entity(name = "shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//主键

    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存
}