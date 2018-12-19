package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.entity.User;
import com.shinedeer.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Calvin Hwang
 * 2018/12/19 21:50
 * 用户 controller
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User saveOne(User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public Integer deleteById(Integer id) {
        try {
            userRepository.delete(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*@PutMapping("/users/{id}")
    public User updateUser(User user) {

        userRepository.save(user);
    }*/

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

}
