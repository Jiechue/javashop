package com.javashop.dao;

import com.javashop.pojo.UsersGift;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserGiftDao {
    UsersGift addGift(Integer userid, Integer giftid) throws SQLException;

    List<Map<String, Object>> selectAllUsersGiftByUid(Integer uid) throws SQLException;
}
