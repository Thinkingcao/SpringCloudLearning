package com.thinkingcao.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-06-19 13:29
 */
@RefreshScope
@RestController
public class ConfigClientController {
    //@Value("${port:没找到配置值，读默认值为80吧}")
    @Value("${blog.url:没找到配置值，读默认值为www.baidu.com吧}")
    private String url;

    @RequestMapping("/message")
    String getMessage() {
        return this.url;
    }
}
