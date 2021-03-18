package com.asylzhan.spring.service;

import com.asylzhan.spring.entity.User;

public interface UserService {
    void create(User user);
    boolean checkUser(String email, String password);
    // checking with email
    boolean hasUser(String email);
    User getUser(String email);
    // add method when user can add movies to "See later list"

//    Page<User> getAll();
//    List<User> getUsersByName(String name);
//    User getById(Long id);
//    void update(Long id, User user);
//    void delete(Long id);
}
