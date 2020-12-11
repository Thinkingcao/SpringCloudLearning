package com.example.trace2;

import org.springframework.stereotype.Component;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/11 10:02
 */
@Component
public class RemoteTrace3ServiceFallback implements RemoteTrace3Service {
    @Override
    public String trace3() {
        return "Trace 3开小差了~";
    }
}
