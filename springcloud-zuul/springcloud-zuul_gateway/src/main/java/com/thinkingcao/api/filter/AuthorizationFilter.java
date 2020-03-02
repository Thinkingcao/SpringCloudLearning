package com.thinkingcao.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 网关Filter过滤器
 * @author: cao_wencao
 * @date: 2020-03-02 11:47
 */
@Component
public class AuthorizationFilter extends ZuulFilter {

    //指定过滤器的类型
    // pre ：可以在请求被路由之前调用
    // route ：在路由请求时候被调用
    // post ：在route和error过滤器之后被调用
    // error ：处理请求时发生错误时被调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序，数值越小，优先级越高。当一个请求在同一阶段的时候存在多个过滤器的时候，通过数值表示过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否执行该过滤器，true 为执行，false 为不执行，这个也可以利用配置中心来实现，达到动态的开启和关闭过滤器。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //执行自己的业务逻辑，编写业务逻辑代码
    @Override
    public Object run() throws ZuulException {
        // 案例：拦截所有的服务接口，判断所有的APi请求，请求头中是否有携带Token参数，用Authorization字段传递

        // 1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取 Request
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取token 的时候 从请求头中获取
        String token =   currentContext .getRequest().getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            // 不会继续执行... 不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("Token参数为空，请先登录后再执行操作");
            currentContext.setResponseStatusCode(401);
             //解决响应给客户端浏览器中文乱码问题
            currentContext.getResponse().setContentType("text/html;chatset=utf-8");
            return null;
            // 返回一个错误提示
        }
        // 正常则执行调用其他服务接口...
        return null;
    }
}
