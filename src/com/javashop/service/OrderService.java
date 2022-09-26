package com.javashop.service;

import com.javashop.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    //查看订单
    List<Order> showOrderListByUid(Integer uid) throws SQLException;
    //是否购买
    boolean buy(Order order) throws SQLException;;
}
