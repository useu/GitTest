package com.dangdang.servlet;

/**
 * ���servlet������ȡ�����ύ�Ĺ��ﳵ�������Ʒ��Ϣ������
 * ���ɶ�����Ȼ�����Ʒ��ֵ���浽������У�Ȼ��ҳ��ת��
 * order.jsp,�ύorder�����form��������������������
 * ���ﳵ�������Ʒ��Ϣ��Ҫ���浽session
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
