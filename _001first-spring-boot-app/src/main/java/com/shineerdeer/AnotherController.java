package com.shineerdeer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Calvin Hwang
 * 2018/11/29 23:55
 * 主程序类包外的 controller
 */
@RestController
public class AnotherController {

    @GetMapping("/another")
    public String another() {
        return "Another Greeting";
    }

}
