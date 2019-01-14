package com.dhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhr.entity.Orders;
import com.dhr.service.OrdersService;

/**
 * Class description
 *
 *
 * @version        $version$, $date$, 19/01/14
 * @author         donghuarui.
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

    /** Field description */
    @Autowired
    private OrdersService ordersService;

    /**
     * 根据userid查询订单
     *
     *
     * @param id
     *
     * @return
     */
    @RequestMapping("findOrdersByUserId")
    public List<Orders> findOrdersByUserId(String id) {
        return ordersService.findOrdersByUserId(id);
    }
}
