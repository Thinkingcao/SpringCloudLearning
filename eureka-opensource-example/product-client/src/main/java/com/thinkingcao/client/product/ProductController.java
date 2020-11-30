package com.thinkingcao.client.product;

import com.alibaba.fastjson.JSONObject;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductService
 * @Author
 * @Version V1.0
 **/
@RestController
public class ProductController {


    @RequestMapping("/getProduct")
    public String getUser() {
        return "product";
    }


}
