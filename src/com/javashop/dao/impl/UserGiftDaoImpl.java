package com.javashop.dao.impl;

import com.javashop.dao.UserGiftDao;
import com.javashop.pojo.UsersGift;
import com.javashop.util.C3P0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserGiftDaoImpl implements UserGiftDao {
    private QueryRunner qRunner = new QueryRunner(C3P0Pool.ds);
    @Override
    public UsersGift addGift(Integer userid, Integer giftid) throws SQLException {
        String sql = "insert into usergift(userId,giftId) values(?,?)";
        return qRunner.insert(sql,new BeanHandler<>(UsersGift.class),userid,giftid);
    }

    @Override
    public List<Map<String, Object>> selectAllUsersGiftByUid(Integer uid) throws SQLException {
        String sql = "select * from usergift where userId = ?";
        List<Map<String, Object>> query =  qRunner.query(sql, new MapListHandler(), uid);
        return query;
    }
}
