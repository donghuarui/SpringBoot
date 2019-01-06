package com.dhr.service;

import com.dhr.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    User findUserByUsername(String username);
}
