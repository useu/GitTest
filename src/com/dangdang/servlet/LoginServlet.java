package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.UserDao;
import com.dangdang.domain.Users;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// 如果用户能够登陆，那么程序（系统）需要一个完整
		// 的用户信息，包括用户的所有信息，包括id，name，password，email，性别
		// 调用m层？ m层代码向UserSqlbean里面写，加一个方法
		// m层一个类，里面多个方法用来完成CRUD不用没次都
		// 创建一个类
		UserDao sqlbean = new UserDao();
		Users user = sqlbean.login(name, password);
		// 流程跳转，根据不同的情况，选择不同的流程
		if (user == null) {
			response.sendRedirect("login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 我想在列表页面显示用户的名字，该如何实现
			RequestDispatcher rd = request.getRequestDispatcher("/BookListServlet?user=" + user.getName());
			rd.forward(request, response);
			// 如何在UserListServlet页面获取到user对象把名字显示出来
			// 下节课提问
			// response.sendRedirect("UserListServlet");
		}
		// 流程跳转
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
