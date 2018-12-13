package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Calvin Hwang
 * 2018/12/12 21:11
 * Hello 控制器类
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String userName) {

        if ("aaa".equals(userName)) {
            throw new UserNotFoundException();
        }

        return "index";
    }
}
