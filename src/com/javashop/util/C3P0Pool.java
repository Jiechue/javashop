package com.javashop.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Pool {
	//获取c3p0连接池对象
	public static DataSource ds=new ComboPooledDataSource();
	
}