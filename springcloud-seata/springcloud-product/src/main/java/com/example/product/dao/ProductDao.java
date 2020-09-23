package com.example.product.dao;

import com.example.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:21
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
}
