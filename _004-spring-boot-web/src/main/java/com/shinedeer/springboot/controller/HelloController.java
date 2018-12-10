package com.shinedeer.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/10 20:42
 * 控制器类
 */
@RequestMapping("/hello")
@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> map) {
        map.put("name", "Calvin");
        return "hello";
    }

}
