package com.javashop.dao.impl;

import com.javashop.dao.OrderDao;
import com.javashop.dao.UserDao;
import com.javashop.pojo.Order;
import com.javashop.pojo.OrderDetail;
import com.javashop.pojo.Users;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Order> selectOrderListByUid(Integer uid) throws SQLException {
        List<Order> list = new ArrayList<>();
        String sql = "select * from orders where userid=?";
        //获取连接对象
        Connection con = C3P0Pool.ds.getConnection();
        //获取sql执行器
        PreparedStatement statement = con.prepareStatement(sql);
        //给sql参数赋值
        statement.setInt(1, uid);
        //执行sql,返回查询结果
        ResultSet rs = statement.executeQuery();
        //循环结果集
        while (rs.next()) {
            //创建一个订单对象，用于封装订单信息
            Order order = new Order();
            //封装订单的日期
            order.setAddDate(rs.getDate("addDate"));
            //封装订单的编号
            order.setId(rs.getInt("id"));
            //封装订单的支付状态
            order.setIsPay(rs.getString("isPay"));
            //封装订单的金额
            order.setTotal(rs.getDouble("total"));
            //根据id获取User对象
            Users users = userDao.selectUsersById(uid);
            //封装订单所属用户
            order.setUsers(users);

            //把封装好的订单增加到集合中
            list.add(order);
        }
        //释放资源省略
        rs.close();
        statement.close();
        con.close();

        return list;
    }

    @Override
    public int buy(Order order) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = C3P0Pool.ds.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into orders(userId,total,addDate,isPay) values(?,?,?,?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, order.getUsers().getId());
            stmt.setObject(2, order.getTotal());
            stmt.setObject(3, order.getAddDate());
            stmt.setObject(4, order.getIsPay());
            if (stmt.executeUpdate() < 0) {
                conn.rollback();
                return 0;
            }
            rs = stmt.getGeneratedKeys();
            int oid = 0;
            if (rs.next()) {
                oid = rs.getInt(1);
            }
            for (OrderDetail detail : order.getOrderList()) {
                sql = "insert into orderdetail(orderId,goodsId,number) values (?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setObject(1, oid);
                stmt.setObject(2, detail.getGoods().getId());
                stmt.setObject(3, detail.getNumber());
                int row = stmt.executeUpdate();
                if (row < 0) {
                    conn.rollback();
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        conn.commit();
        rs.close();
        stmt.close();
        conn.close();
        return 1;
    }
}
