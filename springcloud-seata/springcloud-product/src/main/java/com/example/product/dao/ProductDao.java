package com.example.product.dao;

import com.example.common.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:21
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
