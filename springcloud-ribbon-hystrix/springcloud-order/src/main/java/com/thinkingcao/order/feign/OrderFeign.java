package com.thinkingcao.order.feign;

import com.thinkingcao.order.feign.callback.OrderFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-04-29 20:19
 */
@FeignClient(name = "nacos-product",fallbackFactory = OrderFeignFallbackFactory.class)
public interface OrderFeign {
}
