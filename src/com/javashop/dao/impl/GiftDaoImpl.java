package com.javashop.dao.impl;

import com.javashop.dao.GiftDao;
import com.javashop.pojo.Gift;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GiftDaoImpl implements GiftDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);

    @Override
    public List<Gift> selectAllGift() throws SQLException {
        String sql = "select * from gift";
        return qRunner.query(sql,new BeanListHandler<>(Gift.class));
    }

    @Override
    public Gift selectGift(Integer giftid) throws SQLException {
        String sql = "select * from gift where id = ?";
        return qRunner.query(sql,new BeanHandler<>(Gift.class),giftid);
    }
}
