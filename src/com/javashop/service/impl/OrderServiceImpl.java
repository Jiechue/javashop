package com.javashop.service.impl;

import com.javashop.dao.OrderDao;
import com.javashop.dao.impl.OrderDaoImpl;
import com.javashop.pojo.Order;
import com.javashop.pojo.OrderDetail;
import com.javashop.service.OrderDetailService;
import com.javashop.service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderDetailService detailService = new OrderDetailServiceImpl();
    @Override
    public List<Order> showOrderListByUid(Integer uid) throws SQLException {
        List<Order> list = orderDao.selectOrderListByUid(uid);
        //循环每个订单
        for(Order order:list) {
            //给每一个订单绑定订单明细
            List<OrderDetail>  orderDetailList=new ArrayList<>();
            //给orderDetailList绑定数据,调用订单明细表，传入订单编号
            orderDetailList = detailService.showOrderDetail(order.getId());
            // 把orderDetailList赋值给当前订单中的属性
            order.setOrderList(orderDetailList);
        }
        return list;
    }

    @Override
    public boolean buy(Order order) throws SQLException {
        int i = orderDao.buy(order);
        if (i==0){
            System.out.println("购买失败");
            return false;
        }
        return true;
    }
}
