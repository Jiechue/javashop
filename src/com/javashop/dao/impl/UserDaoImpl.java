package com.javashop.dao.impl;

import com.javashop.dao.UserDao;
import com.javashop.pojo.Users;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);
    @Override
    public Users selectUsers(String name, String pwd) throws SQLException {
        String sql = "select * from users where loginId = ? and loginPwd = ?";
        return qRunner.query(sql, new BeanHandler<Users>(Users.class),name,pwd);
    }

    @Override
    public int updateUsers(Users users) throws SQLException {
        String sql = "update users set loginPwd = ? where loginId = ?";
        return qRunner.update(sql,users.getLoginPwd(),users.getLoginId());
    }

    @Override
    public Users selectUsersById(Integer id) throws SQLException {
        String sql = "select * from users where id = ?";
        return qRunner.query(sql,new BeanHandler<>(Users.class),id);
    }
}
