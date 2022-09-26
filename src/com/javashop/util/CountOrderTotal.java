package com.javashop.util;

import com.javashop.pojo.OrderDetail;

import java.util.List;
//封装计算订单总金额
public class CountOrderTotal {
    public static double CountTotal(List<OrderDetail> orderdetails){
        double num = 0;
        for (int i=0;i<orderdetails.size();i++){
            num = orderdetails.get(i).getNumber()*orderdetails.get(i).getGoods().getPrice();
        }
        return num;
    }
}
