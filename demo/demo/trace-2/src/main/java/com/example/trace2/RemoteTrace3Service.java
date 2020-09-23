package com.example.trace2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/11 10:02
 */
@FeignClient(value = "trace-3",fallback = RemoteTrace3ServiceFallback.class)
@Service
public interface RemoteTrace3Service {
    @GetMapping("trace-3")
    String trace3();
}
