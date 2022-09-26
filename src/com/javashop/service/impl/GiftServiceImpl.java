package com.javashop.service.impl;

import com.javashop.dao.GiftDao;
import com.javashop.dao.impl.GiftDaoImpl;
import com.javashop.pojo.Gift;
import com.javashop.service.GiftService;

import java.sql.SQLException;
import java.util.List;

public class GiftServiceImpl implements GiftService {
    private GiftDao giftDao = new GiftDaoImpl();

    @Override
    public List<Gift> showAllGift() throws SQLException {
        return giftDao.selectAllGift();
    }

    @Override
    public Gift showGift(Integer id) throws SQLException {
        return giftDao.selectGift(id);
    }
}
