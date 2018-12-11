package com.shinedeer.springboot.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Calvin Hwang
 * 2018/12/11 20:21
 * 登录拦截器
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = (String) request.getSession().getAttribute("userName");
        if (StringUtils.isEmpty(userName)) {
            request.setAttribute("errorMsg", "没有权限访问，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false; // 拦截请求
        }
        return true; // 放行
    }
}
