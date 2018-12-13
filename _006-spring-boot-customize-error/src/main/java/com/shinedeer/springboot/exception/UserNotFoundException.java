package com.shinedeer.springboot.exception;

/**
 * @author Calvin Hwang
 * 2018/12/12 22:00
 * 自定义用户不存在异常
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("用户不存在");
    }
}
