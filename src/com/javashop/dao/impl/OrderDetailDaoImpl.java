package com.javashop.dao.impl;

import com.javashop.dao.OrderDetailDao;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDetailDaoImpl implements OrderDetailDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);
    @Override
    public List<Map<String, Object>> selectOrderDetailByOrder(Integer uid) throws SQLException {
        String sql = "select * from orderdetail where orderId = ?";
        //尝试一下用map取出id再在业务层访问Dao层封装
        List<Map<String, Object>> query =  qRunner.query(sql, new MapListHandler(), uid);
        return query;
    }
}
