package com.shinedeer.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/11 19:22
 * 登录控制器
 */
@RequestMapping("/user")
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String password,
                        HttpSession session,
                        Map<String, Object> map) {

        if (!StringUtils.isEmpty(userName)
            && !StringUtils.isEmpty(password)) {
            if (userName.equals(password)) {

                session.setAttribute("userName", userName); // 用户信息存入session 作用域

                // return "dashboard"; // 进入主页面板
                // 为了避免表单重复提交，使用重定向
                return "redirect:/main.html";
            }
        }

        map.put("errorMsg", "登录错误");
        return "login.html"; // 转发到登录页

        // 由于我们要往登录页面传递反馈数据，所以不能用重定向
        // return "redirect:../index.html"; // 重定向回登录页
    }
}
