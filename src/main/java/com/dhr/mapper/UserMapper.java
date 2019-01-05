package com.dhr.mapper;

import com.dhr.entity.User;
import org.apache.ibatis.annotations.Select;


import java.util.List;
public interface UserMapper {

     @Select("select * from user")
     List<User> selectAll();
}
