package com.thinkingcao.api.service.impl;

import com.thinkingcao.api.Feign.IExcuteHystrixHandler;
import org.springframework.stereotype.Component;

/**
 * @desc: GetHystrixResultImpl注入到Spring容器，交给Spring管理
 * @author: cao_wencao
 * @date: 2020-02-25 12:59
 */
@Component
public class GetHystrixResultImpl implements IExcuteHystrixHandler {
    @Override
    public String getHystrixInfo() {
        return  "您好，当前系统人数较多，请稍后重试，给您带来的不便，敬请谅解！！！";
    }
}
