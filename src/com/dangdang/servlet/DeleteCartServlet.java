package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.CarDao;
import com.dangdang.domain.Book;
import com.dangdang.domain.ShopCar;
import com.dangdang.domain.Users;

public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids =request.getParameter("id");
		int bookid = Integer.parseInt(ids);
		CarDao cartDao = new CarDao();
		cartDao.delCart(bookid);
		response.sendRedirect("CartListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
