package com.shinedeer.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author Calvin Hwang
 * 2018/12/19 20:14
 * MyBatis 配置类
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 开启下划线转驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
