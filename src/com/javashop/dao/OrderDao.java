package com.javashop.dao;

import com.javashop.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Order> selectOrderListByUid(Integer uid) throws SQLException;

    int buy(Order order) throws SQLException;
}
