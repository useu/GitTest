package com.dangdang.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.connector.Request;

import com.dangdang.domain.Users;
import com.dangdang.util.Connector;


public class UserDao {
	// ��������ķŻ�ֵ��void����Ϊ����һ������������û�з���ֵ
	// �������޸ģ�ɾ���ķ�����û�з���ֵ������void�����ǲ�ѯһ���з���ֵ
	public void addUser(Users u) {
		// �������ݿ⣬�������,jsp�����jdbc����Ϊjsp������ʱ�������try
		try {
			Connection conn = Connector.getConnection();
			String sql = "insert into users values(default,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ��½�Ĵ���ķ���ֵ�Ƚ��ر�
	// ����û��ܹ���½������һ����ɵ�user����
	// ���ܵ�¼������null
	public Users login(String name, String password) {
		Users u = null;
		Connection conn = Connector.getConnection();
		String sql = "select * from users where name1=? and password=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {// ����Ĵ�������ܹ���½Ȼ�󴴽�user����Ȼ��
							// �����ݿ������ֵ��user����ֵ�Ĺ���
				u = new Users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// �������ݿ�Ĵ���
		return u;
	}

}
