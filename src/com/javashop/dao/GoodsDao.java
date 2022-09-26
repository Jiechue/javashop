package com.javashop.dao;

import com.javashop.pojo.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    //查找对应商品
    Goods selectGoodById (Integer id) throws SQLException;
    //查找所有商品
    List<Goods> selectGoods() throws SQLException;
}
