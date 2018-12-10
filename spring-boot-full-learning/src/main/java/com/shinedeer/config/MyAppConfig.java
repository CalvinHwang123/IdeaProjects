package com.shinedeer.config;

import com.shinedeer.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Calvin Hwang
 * 2018/11/24 21:00
 * 自定义配置类
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println("自定义配置类添加 helloService 组件");
        return new HelloService();
    }

}
