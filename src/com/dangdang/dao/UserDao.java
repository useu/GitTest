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
	// 这个方法的放回值是void是因为这是一个新增操作，没有返回值
	// 新增，修改，删除的方法都没有返回值，都是void，但是查询一定有返回值
	public void addUser(Users u) {
		// 连接数据库，完成新增,jsp里面的jdbc是因为jsp被翻译时候，添加了try
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

	// 登陆的代码的返回值比较特别
	// 如果用户能够登陆，返回一个完成的user对象
	// 不能登录，返回null
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
			if (rs.next()) {// 下面的代码就是能够登陆然后创建user对象，然后
							// 用数据库里面的值给user对象赋值的过程
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

		// 连接数据库的代码
		return u;
	}

}
