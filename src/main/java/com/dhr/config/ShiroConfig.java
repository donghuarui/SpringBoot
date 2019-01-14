package com.dhr.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 *
 * @author donghuarui.
 * @version $version$, $date$, 19/01/06
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建 ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器
        /**
         * shiro内置过滤器,可以实现权限相关的拦截器
         * 常用的过滤器:
         *     anon: 无需认证(登录)可以访问
         *     authc:  必须认证才可以访问
         *     user: 如果使用rememberMe的功能可以直接访问
         *     perms:  该资源必须得到资源权限才可以访问
         *     role: 该资源必须得到资源权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/test","anon");
        filterMap.put("/user/toLogin","anon");
        filterMap.put("/user/login","anon");
        //授权过滤器
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/user/*","authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建 DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建 Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }


    /**
     * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     * @return
     */
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}


