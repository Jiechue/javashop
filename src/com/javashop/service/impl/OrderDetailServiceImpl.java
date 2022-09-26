package com.javashop.service.impl;

import com.javashop.dao.GoodsDao;
import com.javashop.dao.OrderDetailDao;
import com.javashop.dao.impl.GoodsDaoImpl;
import com.javashop.dao.impl.OrderDetailDaoImpl;
import com.javashop.pojo.OrderDetail;
import com.javashop.service.OrderDetailService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao detailDao = new OrderDetailDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<OrderDetail> showOrderDetail(Integer uid) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        List<Map<String, Object>> query = detailDao.selectOrderDetailByOrder(uid);
        for (Map map : query) {
            OrderDetail detail = new OrderDetail();
            detail.setId((Integer) map.get("id"));
            detail.setNumber(Double.valueOf((Integer) map.get("number")));
            detail.setGoods(goodsDao.selectGoodById((Integer) map.get("goodsId")));
            list.add(detail);
        }
        return list;
    }
}
