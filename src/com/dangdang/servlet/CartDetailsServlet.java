package com.dangdang.servlet;

/**
 * 这个servlet用来获取我们提交的购物车里面的商品信息，用来
 * 生成订单，然后把商品的值保存到域对象中，然后页面转到
 * order.jsp,提交order里面的form才真正声场订单，所以
 * 购物车里面的商品信息需要保存到session
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartDetailsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] details = request.getParameterValues("cartDetails");
		HttpSession session = request.getSession();
		session.setAttribute("carts", details);
		response.sendRedirect("order.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
