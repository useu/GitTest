package com.dangdang.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.CarDao;
import com.dangdang.domain.ShopCar;



public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarDao cartDao = new CarDao();
		List<ShopCar> list = cartDao.cartList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
