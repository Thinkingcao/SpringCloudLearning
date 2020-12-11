package com.example.trace1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/10 14:24
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RemoteTrace2Service remoteTrace2Service;

    @GetMapping("trace-1")
    public String trace1() {
        logger.info("trace1调用...");
        return remoteTrace2Service.trace2();
    }

    @GetMapping("trace-1/{msg}")
    public String dealMsg(@PathVariable("msg") String msg) {
        logger.info("收到消息：{}", msg);
        return remoteTrace2Service.dealMsg(msg);
    }
}
