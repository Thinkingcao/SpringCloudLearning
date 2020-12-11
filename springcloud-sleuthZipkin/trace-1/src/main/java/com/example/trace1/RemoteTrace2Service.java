package com.example.trace1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 张凡进
 * @Description 两个@FeignClient，若想知道降级的原因使用fallbackFactory,否则可使用fallback
 * @Date 2019/4/10 14:28
 */
//@FeignClient(value = "trace-2", fallback = RemoteTrace2ServiceFallback.class)
@FeignClient(value = "trace-2", fallbackFactory = HystrixClientFallbackFactory.class)
@Service
public interface RemoteTrace2Service {

    /**
     * 调用TRACE-2服务的/trace-2接口
     *
     * @return
     */
    @GetMapping("/trace-2")
    String trace2();

    /**
     * 调用TRACE-2服务的/trace-2{msg}接口
     *
     * @param msg
     * @return
     */
    @GetMapping("trace-2/{msg}")
    String dealMsg(@PathVariable("msg") String msg);
}
