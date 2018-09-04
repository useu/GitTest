package com.dangdang.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.domain.Booktype;
import com.dangdang.domain.Users;
import com.dangdang.util.Connector;

public class TypeDao {
	public void addItem(Booktype bt) {
		Connection conn = Connector.getConnection();
		String sql = "insert into booktype values(default,?,?,?,?,1)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bt.getBookName());
			ps.setInt(2, bt.getBook().getId());
			ps.setInt(3, bt.getOrderId());
			ps.setInt(4, bt.getCount());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
