package com.shinedeer;

import com.shinedeer.component.MyLocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

// @ImportResource(locations = "classpath:beans.xml") Spring Boot 并不推荐使用配置文件方式，推荐使用注解的方式
@SpringBootApplication
public class SpringBootFullLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFullLearningApplication.class, args);
	}

	/**
	 * 用于测试自定义 视图解析器 是否会被 dispatchServlet 处理
	 * @return
	 */
	@Bean
	public ViewResolver returnViewResolver() {
		return new MyViewResolver();
	}

	private class MyViewResolver implements ViewResolver {

		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}

}
