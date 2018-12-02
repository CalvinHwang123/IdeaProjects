package com.shineerdeer.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Calvin Hwang
 * 2018/11/29 21:17
 * hello 请求控制器
 */
@RestController
public class HelloController {

    @GetMapping({"/", "/hello"})
    public String greeting() {
        return "Hello Spring Boot";
    }

}
