package com.dhr.controller;

import com.dhr.entity.User;
import com.dhr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.selectAll();
        System.out.print(213345);
        return  users;
    }
}
