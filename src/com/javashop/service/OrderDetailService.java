package com.javashop.service;

import com.javashop.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailService {
    //查看订单详细
    List<OrderDetail> showOrderDetail(Integer uid) throws SQLException;

}
