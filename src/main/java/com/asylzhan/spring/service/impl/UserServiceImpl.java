package com.asylzhan.spring.service.impl;

import com.asylzhan.spring.entity.User;
import com.asylzhan.spring.repo.UserRepo;
import com.asylzhan.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public boolean checkUser(String email, String password) {
        User user = userRepo.getUserByEmailAndPassword(email, password);
        return (user != null);
    }

    @Override
    public boolean hasUser(String email) {
        User user = userRepo.getUserByEmail(email);
        return (user != null);
    }

    @Override
    public User getUser(String email) {
        return userRepo.getUserByEmail(email);
    }
}
