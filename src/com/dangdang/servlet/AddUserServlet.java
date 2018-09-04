package com.dangdang.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.UserDao;
import com.dangdang.domain.Users;




public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public AddUserServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		////��ȡ���������е�c���һ���¶������
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//�������������Է�װ��һ������
		Users u = new Users(email,name,password);
		
		//����m��
		UserDao sqlBean = new UserDao();
		sqlBean.addUser(u);
		//������ת,����������̵�תҲ����ת����һ��
		//servlet������ֱ�ӵ�ת����һ��jsp
		//UserListServlet���Ǵ���
		response.sendRedirect("LoginServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
