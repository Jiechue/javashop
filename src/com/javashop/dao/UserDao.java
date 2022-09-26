package com.javashop.dao;

import com.javashop.pojo.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //查找输入的用户是否存在于数据库
    Users selectUsers(String name,String pwd) throws SQLException;
    //
    int updateUsers(Users users) throws SQLException;

    Users selectUsersById(Integer id) throws SQLException;
}
