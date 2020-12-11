package com.example.trace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/10 14:48
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RemoteTrace3Service remoteTrace3Service;

    @GetMapping("trace-2")
    public String trace2() {
        logger.info("trace2调用...");
        return remoteTrace3Service.trace3();
    }

    @GetMapping("trace-2/{msg}")
    public String dealMsg(@PathVariable("msg") String msg) {
        logger.info("interface /trace-2/{msg} received: {}", msg);
        return "Interface /trace-2/{msg} of TRACE-2 received your message: <b>" + msg + "</b>";
    }
}
