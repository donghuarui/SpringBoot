package com.dhr.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhr.entity.User;
import com.dhr.service.UserService;

/**
 * Class description
 *
 * @author donghuarui.
 * @version $version$, $date$, 19/01/06
 */
@Component
public class UserRealm extends AuthorizingRealm {

    /**
     * Field description
     */
    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.print("执行认证逻辑");

        // 编写shiro判断逻辑,判断用户名和密码
        // 1.判断用户名
        UsernamePasswordToken thisToken = (UsernamePasswordToken) token;
        User user = userService.findUserByUsername(thisToken.getUsername());
         
        if (user == null) {

            // 用户名不存在
            // shiro底层抛出UnknownAccountException
            return null;
        }

        // 2.判断密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.print("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //从数据库获取当前登录用户的授权字符串
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        System.err.print(user.getPerms());
        info.addStringPermission(user.getPerms());
        return info;
    }
}


