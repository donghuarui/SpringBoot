package com.dhr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import com.dhr.entity.User;

/**
 * Interface description
 *
 * @author donghuarui.
 */
@Repository
public interface UserMapper {

//  @Select("select * from user")

    /**
     * Method description
     *
     * @return
     */
    List<User> findUserAndOrders();

    User findUserByUsername(String username);
}
