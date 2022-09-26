package com.javashop.service.impl;

import com.javashop.dao.GoodsDao;
import com.javashop.dao.impl.GoodsDaoImpl;
import com.javashop.pojo.Goods;
import com.javashop.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> showAllGoods() throws SQLException {
        return goodsDao.selectGoods();
    }

    @Override
    public Goods showGoodById(Integer id) throws SQLException {
        return goodsDao.selectGoodById(id);
    }
}
