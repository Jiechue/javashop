package com.javashop.dao.impl;

import com.javashop.dao.GoodsDao;
import com.javashop.pojo.Goods;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);
    @Override
    public Goods selectGoodById(Integer id) throws SQLException {
        String sql = "select * from goods where id = ?";
        return qRunner.query(sql,new BeanHandler<>(Goods.class),id);
    }

    @Override
    public List<Goods> selectGoods() throws SQLException {
        String sql = "select * from goods";
        return qRunner.query(sql,new BeanListHandler<>(Goods.class));
    }
}
