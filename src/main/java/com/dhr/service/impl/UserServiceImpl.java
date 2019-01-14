package com.dhr.service.impl;

import com.dhr.entity.User;
import com.dhr.mapper.UserMapper;
import com.dhr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
