package com.renjing.mybatis.mapper;

import com.renjing.mybatis.po.OrdersUserCustomer;

import java.util.List;

public interface OrdersUserMapper {
    public List<OrdersUserCustomer> findOrderUserList();
}
