package com.thinkingcao.order.feign.callback;

import com.thinkingcao.order.feign.OrderFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-04-29 20:45
 */
@Component
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeign> {
    @Override
    public OrderFeign create(Throwable throwable) {
        return null;
    }
}
