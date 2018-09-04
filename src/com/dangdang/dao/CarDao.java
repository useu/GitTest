package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.domain.Book;
import com.dangdang.domain.ShopCar;
import com.dangdang.util.Connector;

public class CarDao {
	public List<ShopCar> cartList() {
		List<ShopCar> list = new ArrayList<ShopCar>();
		String sql = "select * from car";
		Connection conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// 遍历结果集封装cart对象
			// 我们从cart表获取到的是bookid，根据bookid调用
			// bookdetail查询到书的信息
			BookDao bookDao = new BookDao();
			Book book = new Book();
			while (rs.next()) {
				ShopCar cart = new ShopCar();
				cart.setId(rs.getInt(1));
				// 给book变量设置id
				book.setId(rs.getInt(3));
				// 根据book去查询获得书的详情，得到书b
				Book b = bookDao.bookDetail(book);
				// 把b设置给cart
				cart.setBook(b);
				cart.setCount(rs.getInt(4));
				list.add(cart);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void addCart(ShopCar cart) {
		Connection conn = Connector.getConnection();
		String sql = "insert into car values(default,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getUser().getId());
			ps.setInt(2, cart.getBook().getId());
			ps.setInt(3, cart.getCount());
			ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delCart(int id) {
		Connection conn = Connector.getConnection();
		String sql = "delete from car where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
