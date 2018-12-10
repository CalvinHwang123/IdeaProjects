package com.shinedeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/11/25 21:34
 * 登录请求 controller
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (userName.equals(password)) {

            // 登录成功用户放入 session
            session.setAttribute("loginUser", userName);

            return "redirect:/main.html";
        } else {
            map.put("result", "登录失败");
            return "index";
        }
    }

}
