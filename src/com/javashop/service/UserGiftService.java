package com.javashop.service;

import com.javashop.pojo.Gift;
import com.javashop.pojo.UsersGift;

import java.sql.SQLException;
import java.util.List;

public interface UserGiftService {
    UsersGift addGiftInUser(Integer userid, Integer giftid) throws SQLException;

    List<UsersGift> showAllUsersGiftByUid(Integer uid) throws SQLException;
}
