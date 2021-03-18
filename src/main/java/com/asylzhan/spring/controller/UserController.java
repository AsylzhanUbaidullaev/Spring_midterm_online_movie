package com.asylzhan.spring.controller;

import com.asylzhan.spring.entity.User;
import com.asylzhan.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public boolean hasUser(String email, String password) {
        return userService.checkUser(email, password);
    }

    public boolean hasUser(String email) {
        return userService.hasUser(email);
    }

    public void saveUser(User user) {
        userService.create(user);
    }

    public User getUser(String email) {
        return userService.getUser(email);
    }
}
