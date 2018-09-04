package com.dangdang.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dangdang.util.Connector;
import com.dangdang.domain.Order;


public class OrderDao {
	// ��������ո����ɵĶ����Ե�id
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
			ResultSet rs = ps.getGeneratedKeys();// ���ط����Զ����ɵ�id��ֵ
			if (rs.next()) {
				id = rs.getInt(1);
				// ������������Ļ������Ϣͬʱ��ӵ� item���У����һ���Ҫ��
				// �ոո��������Ϣ�ӹ��ﳵ��ɾ����

				System.out.println("�ո����ɵ�id = " + id);

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
