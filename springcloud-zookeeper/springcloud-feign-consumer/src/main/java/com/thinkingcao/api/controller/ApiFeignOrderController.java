package com.thinkingcao.api.controller;

import com.thinkingcao.api.feign.IFeignOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-24 12:27
 */
@RestController
public class ApiFeignOrderController {

    @Autowired(required = false)
    private IFeignOrderService feignOrderService;


    @RequestMapping(value ="/getMemberInfo",method = RequestMethod.GET)
    public String getMemberInfo(@RequestParam("userName") String userName) {
        String memberInfo = feignOrderService.getMember(userName);
        return memberInfo;
    }



}
