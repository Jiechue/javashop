package com.javashop.service;

import com.javashop.pojo.Gift;

import java.sql.SQLException;
import java.util.List;

public interface GiftService {
    List<Gift> showAllGift() throws SQLException;
    Gift showGift(Integer id) throws SQLException;
}
