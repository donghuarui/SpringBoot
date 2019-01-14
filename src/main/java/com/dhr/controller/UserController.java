package com.dhr.controller;

import com.dhr.entity.User;
import com.dhr.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        List<User> users = userService.selectAll();
        return users;
    }

    @RequestMapping("/test")
    public String testTemplate(Model model){
        model.addAttribute("username","dhr");
        return "test";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }

    /**
     * 登录处理逻辑
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1. 获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //3.执行登录方法
        try {
            //登录成功

            subject.login(token);
            return "redirect:test";
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
