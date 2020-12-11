package com.example.trace1;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author 张凡进
 * @Description 服务降级，可得知产生降级的原因
 * @Date 2019/4/16 10:34
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<RemoteTrace2Service> {
    @Override
    public RemoteTrace2Service create(Throwable cause) {
        return new RemoteTrace2Service() {
            @Override
            public String trace2() {
                return "TRACE-2 服务/trace-2接口异常，reason: " + cause.getMessage();
            }

            @Override
            public String dealMsg(String msg) {
                return "TRACE-2 服务/trace-2/{msg}接口异常，reason: " + cause.getMessage();
            }
        };
    }
}
