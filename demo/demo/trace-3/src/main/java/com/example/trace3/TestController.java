package com.example.trace3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张凡进
 * @Description
 * @Date 2019/4/11 10:00
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("trace-3")
    public String trace3() {
        logger.info("Trace 3 调用...");
        return "trace 3";
    }
}
