package com.javashop.service.impl;

import com.javashop.dao.GiftDao;
import com.javashop.dao.UserDao;
import com.javashop.dao.UserGiftDao;
import com.javashop.dao.impl.GiftDaoImpl;
import com.javashop.dao.impl.UserDaoImpl;
import com.javashop.dao.impl.UserGiftDaoImpl;
import com.javashop.pojo.UsersGift;
import com.javashop.service.UserGiftService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserGiftServiceImpl implements UserGiftService {
    private UserGiftDao userGiftDao = new UserGiftDaoImpl();
    private GiftDao giftDao = new GiftDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    @Override
    public UsersGift addGiftInUser(Integer userid, Integer giftid) throws SQLException {
        return userGiftDao.addGift(userid,giftid);
    }

    @Override
    public List<UsersGift> showAllUsersGiftByUid(Integer uid) throws SQLException {
        List<UsersGift> list = new ArrayList<>();
        List<Map<String, Object>> mapz = userGiftDao.selectAllUsersGiftByUid(uid);
        for (Map map : mapz){
            UsersGift usersGift = new UsersGift();
            usersGift.setId((Integer) map.get("id"));
            usersGift.setUsers(userDao.selectUsersById((Integer) map.get("userId")));
            usersGift.setGift(giftDao.selectGift((Integer) map.get("giftId")));
            list.add(usersGift);
        }
        return list;
    }
}
