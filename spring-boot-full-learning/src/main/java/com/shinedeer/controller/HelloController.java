package com.shinedeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/11/24 21:44
 * Hello 请求控制器
 */
// @RestController // 如果有页面跳转，则不能使用 @RestControler
@Controller
public class HelloController {

    /**
     * 我是一款骚气蓬勃的主题，我叫做 Material Theme UI
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("engineer", "Thymeleaf 号称页面即原型，这是后端返回的数据");
        map.put("text", "<code>我是代码块</code>");
        map.put("list", Arrays.asList("你好", "Java", 123));
        return "success";
    }

    /**
     * 如果要写成 RESTful 风格，这里不应该返回页面名称
     */
    /*@RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }*/

}
