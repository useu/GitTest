package com.dangdang.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dangdang.util.Connector;
import com.dangdang.domain.Order;


public class OrderDao {
	// 返回这个刚刚生成的订单对的id
	public int addOrder(Order order) {
		int id = 0;
		Connection conn = Connector.getConnection();
		String sql = "insert into orders values(default,?,?,?,?,1)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getName());
			ps.setString(2, order.getAddress());
			ps.setString(3, order.getTel());
			ps.setString(4, order.getSub());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();// 返回方法自动生成的id的值
			if (rs.next()) {
				id = rs.getInt(1);
				// 属于这个订单的货物的信息同时添加到 item表中，而且还需要把
				// 刚刚付过款的信息从购物车中删除，

				System.out.println("刚刚生成的id = " + id);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;

	}

	
}
