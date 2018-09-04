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
		// ��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// ����û��ܹ���½����ô����ϵͳ����Ҫһ������
		// ���û���Ϣ�������û���������Ϣ������id��name��password��email���Ա�
		// ����m�㣿 m�������UserSqlbean����д����һ������
		// m��һ���࣬�����������������CRUD����û�ζ�
		// ����һ����
		UserDao sqlbean = new UserDao();
		Users user = sqlbean.login(name, password);
		// ������ת�����ݲ�ͬ�������ѡ��ͬ������
		if (user == null) {
			response.sendRedirect("login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// �������б�ҳ����ʾ�û������֣������ʵ��
			RequestDispatcher rd = request.getRequestDispatcher("/BookListServlet?user=" + user.getName());
			rd.forward(request, response);
			// �����UserListServletҳ���ȡ��user�����������ʾ����
			// �½ڿ�����
			// response.sendRedirect("UserListServlet");
		}
		// ������ת
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
