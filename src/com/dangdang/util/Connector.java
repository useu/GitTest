package com.dangdang.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/**
	 * 返回conn对象，默认的数据库是student
	 * 
	 * @return
	 */
	public static Connection getConnection()// 静态方法不需要创建对象就可以调用
	{// 用来返回conn对象
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dangdang";
			String u = "root";
			String p = "545383059";
			conn = DriverManager.getConnection(url, u, p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
