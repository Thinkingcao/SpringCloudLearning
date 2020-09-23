package com.example.product.service.impl;

import com.example.common.product.entity.Product;
import com.example.product.dao.ProductDao;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:20
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    /**
     * 扣减库存
     * @param pid
     * @param number
     */
    @Transactional
    @Override
    public void reduceInventory(Integer pid, Integer number) {
        //查询
        Product product = productDao.findById(pid).get();
        //省略校验

        //内存中扣减
        product.setStock(product.getStock() - number);

        //模拟异常
        int i = 1 / 0;

        //保存扣减库存
        productDao.save(product);
    }


}
