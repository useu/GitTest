package com.dangdang.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	/**
	 * ����conn����Ĭ�ϵ����ݿ���student
	 * 
	 * @return
	 */
	public static Connection getConnection()// ��̬��������Ҫ��������Ϳ��Ե���
	{// ��������conn����
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
