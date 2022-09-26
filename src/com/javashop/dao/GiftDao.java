package com.javashop.dao;

import com.javashop.pojo.Gift;

import java.sql.SQLException;
import java.util.List;

public interface GiftDao {
    List<Gift> selectAllGift() throws SQLException;
    Gift selectGift(Integer giftid) throws SQLException;
}
