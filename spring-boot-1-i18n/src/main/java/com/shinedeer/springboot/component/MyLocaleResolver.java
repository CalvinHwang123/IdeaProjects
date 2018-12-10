package com.shinedeer.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Calvin Hwang
 * 2018/11/26 19:59
 * 自定义 区域 解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getParameter("lang");
        Locale locale = Locale.getDefault(); // 如果不带区域请求，就用系统默认的
        if (!StringUtils.isEmpty(lang)) {
            String language = lang.split("_")[0];
            String country = lang.split("_")[1];
            locale = new Locale(language, country);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
