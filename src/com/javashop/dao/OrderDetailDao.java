package com.javashop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderDetailDao {
    List<Map<String, Object>> selectOrderDetailByOrder(Integer uid) throws SQLException;
}
