package com.shinedeer.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/12 22:26
 * 自定义错误 attributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("extMap", webRequest.getAttribute("extMap", WebRequest.SCOPE_REQUEST));
        map.put("company", "闲鹿科技");
        return map;
    }
}
