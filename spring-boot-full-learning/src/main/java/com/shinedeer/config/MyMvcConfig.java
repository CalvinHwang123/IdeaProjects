package com.shinedeer.config;

import com.shinedeer.component.LoginHandlerInterceptor;
import com.shinedeer.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author Calvin Hwang
 * 2018/11/25 16:51
 * 自定义 mvc 配置类
 */
// @EnableWebMvc // 全面接管 Spring MVC，取消 Spring Boot 自动配置
@Configuration
// extends WebMvcConfigurerAdapter 已经过时了
// p.s. 这里继承了 WebMvcConfigurationSupport,不需要加 @EnableWebMvc，直接使得自动配置失效了
//public class MyMvcConfig extends WebMvcConfigurationSupport {
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 扩展 Spring MVC
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 注意 bean 的命名 localeResolver
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 这样写拦截器还是会拦截 静态资源
     * @return
     */
    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor())
            .addPathPatterns("/**") // 添加拦截规则
            .excludePathPatterns("/", "/login", "/index", "/index.html"); // 排除路径;
    }

    /**
     * 多个 WebMvcConfigurerAdapter 会一起起作用
     * @return
     */
    /*@Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            *//**
             * 注册拦截器
             * @param registry
             *//*
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                    .addPathPatterns("/**") // 添加拦截规则
                    .excludePathPatterns("/", "/login", "/index", "/index.html"); // 排除路径
            }

            *//**
             * 配置拦截器 一定要 重新指定静态资源位置？
             * @param registry
             *//*
            *//*@Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // 可以都配了
                // "classpath:/META-INF/resources/", "classpath:/resources/",
                // "classpath:/static/", "classpath:/public/"
                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
                super.addResourceHandlers(registry); // 这句不要注释
            }*//*
        };
    }*/

}
