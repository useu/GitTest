package com.dangdang.servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.CarDao;
import com.dangdang.domain.Book;
import com.dangdang.domain.ShopCar;
import com.dangdang.domain.Users;


public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String counts = request.getParameter("count");
		String ids =request.getParameter("id");
		int count = Integer.parseInt(counts);
		int bookid = Integer.parseInt(ids);
		// cart 表 一四个字段 count，bookid ，
		HttpSession session = request.getSession();
		Users user =(Users)session.getAttribute("user");
		int userid = user.getId();
		//把上述数据封装成一个Cart对对象
		ShopCar cart = new ShopCar();
		cart.setCount(count);
		cart.setUser(user);
		Book book = new Book();
		book.setId(bookid);
		cart.setBook(book);//只有书的id值
		CarDao cartDao = new CarDao();
		cartDao.addCart(cart);
		response.sendRedirect("CartListServlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	 }
	
	}
