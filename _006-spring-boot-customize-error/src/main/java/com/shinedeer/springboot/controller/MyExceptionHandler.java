package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/12 22:06
 * 自定义异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 这样子浏览器和移动端都是返回 json 数据
    /*@ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public Map<String, Object> handleException() {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("code", "notfound");
        errorMap.put("message", "找不到对象");
        return errorMap;
    }*/

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("code", "notfound");
        errorMap.put("message", "找不到对象");

        request.setAttribute("extMap", errorMap);

        return "forward:/error";
    }

}
