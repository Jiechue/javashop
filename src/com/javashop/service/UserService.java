package com.javashop.service;

import com.javashop.pojo.Users;

public interface UserService {
    //登录
    Users login(String name, String pwd) throws Exception;
    //修改
    boolean update(Users user) throws Exception;
}
