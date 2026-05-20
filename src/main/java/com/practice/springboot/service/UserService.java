package com.practice.springboot.service;

import com.practice.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer id);
    List<User> getAllUSer();
    User updateUser(User user, Integer id);
    String deleteUser(Integer id);
}
