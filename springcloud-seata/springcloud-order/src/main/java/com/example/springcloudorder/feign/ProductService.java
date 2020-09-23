package com.example.springcloudorder.feign;

import com.example.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-09-22 23:43
 */
@FeignClient(value = "service-product")
public interface ProductService {
    //@FeignClient的value +  @RequestMapping的value值  其实就是完成的请求地址  "http://service-product/product/" + pid
    //指定请求的URI部分
    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable Integer pid);

    //扣减库存
    //参数一: 商品标识
    //参数二:扣减数量
    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid,
                         @RequestParam("number") Integer number);
}