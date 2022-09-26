package com.javashop.service;

import com.javashop.pojo.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    //所有商品
    List<Goods> showAllGoods() throws SQLException;

    Goods showGoodById (Integer id) throws SQLException;
}
