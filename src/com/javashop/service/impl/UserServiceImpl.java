package com.javashop.service.impl;

import com.javashop.dao.UserDao;
import com.javashop.dao.impl.UserDaoImpl;
import com.javashop.pojo.Users;
import com.javashop.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public Users login(String name, String pwd) throws Exception {
        return userDao.selectUsers(name, pwd);
    }

    @Override
    public boolean update(Users user) throws Exception {
        if (userDao.updateUsers(user)>0){
            return true;
        }else {
            return false;
        }
    }
}
