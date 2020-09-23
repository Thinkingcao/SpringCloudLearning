package com.example.springcloudorder.dao;


import com.example.common.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:31
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
