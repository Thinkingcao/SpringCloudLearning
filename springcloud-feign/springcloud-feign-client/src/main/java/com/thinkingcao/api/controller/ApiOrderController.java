package com.thinkingcao.api.controller;

import com.thinkingcao.api.Feign.IFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-22 12:30
 */
@RestController
public class ApiOrderController {

    @Autowired(required=false)
    private IFeignClientService feignClientService;

    @RequestMapping(value = "/getMemberInfo",method = RequestMethod.GET)
    public String getMemberInfo(@RequestParam("userName") String userName){
        String memberInfo = feignClientService.getOrderToMemberInfo(userName);
        return memberInfo;
    }

}
