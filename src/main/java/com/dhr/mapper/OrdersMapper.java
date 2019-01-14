package com.dhr.mapper;

import com.dhr.entity.Orders;
import com.dhr.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface description
 *
 * @author donghuarui.
 */
@Repository
public interface OrdersMapper {


    /**
     * Method description
     *
     * @return
     */
    List<Orders> findOrdersByUserId(String id);
}
