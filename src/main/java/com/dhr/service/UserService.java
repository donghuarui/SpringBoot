package com.dhr.service;

import java.util.List;

import com.dhr.entity.Orders;
import com.dhr.entity.User;

/**
 * Interface description
 *
* @author         donghuarui.
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     *
     *
     * @param username
     *
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 查询全部用户
     *
     *
     * @return
     */
    List<User> findUserAndOrders();
}
