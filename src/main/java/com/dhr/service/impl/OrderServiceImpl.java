package com.dhr.service.impl;

import com.dhr.entity.Orders;
import com.dhr.mapper.OrdersMapper;
import com.dhr.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService{
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findOrdersByUserId(String id) {
        return ordersMapper.findOrdersByUserId(id);
    }
}
