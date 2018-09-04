package com.dangdang.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.domain.Book;

import com.dangdang.util.Connector;

public class BookDao {
	public int bookCount()
	{
		int count = 0;
		Connection conn = Connector.getConnection();
		String sql = "select count(*) from book";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = 	ps.executeQuery();
			if(rs.next())
			{
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<Book> bookList(int currentPage,int pageSize)
	{
		List<Book> list = new ArrayList<Book>();
		String sql="select * from book limit ?,?";
		Connection conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (currentPage-1)*pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setPublish(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setLeftcount(rs.getInt(5));
			b.setAuthor(rs.getString(6));
			b.setUrl(rs.getString(7));
			b.setJifen(rs.getInt(8));
			b.setDiscount(rs.getDouble(9));
			list.add(b);
			
		}
		
		rs.close();
		ps.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 根据书的id查询书的详情
	 * @param book
	 * @return
	 */

	public Book bookDetail(Book book)
	{
		Book b = null;
		Connection conn = Connector.getConnection();
		String sql = "select * from book where id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				b = new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublish(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setLeftcount(rs.getInt(5));
				b.setAuthor(rs.getString(6));
				b.setUrl(rs.getString(7));
				b.setJifen(rs.getInt(8));
				b.setDiscount(rs.getDouble(9));
			
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return b;
		
		
	}
	public Book getBookById(int id)
	{
		Book b = null;
		Connection conn = Connector.getConnection();
		String sql = "select * from book where id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				b = new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublish(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setLeftcount(rs.getInt(5));
				b.setAuthor(rs.getString(6));
				b.setUrl(rs.getString(7));
				b.setJifen(rs.getInt(8));
				b.setDiscount(rs.getDouble(9));
			
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return b;
		
		
	}




}
