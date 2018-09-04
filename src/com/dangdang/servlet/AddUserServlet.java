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
		////获取参数、所有的c层第一件事都是这个
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//把上面三个属性封装成一个对象
		Users u = new Users(email,name,password);
		
		//调用m层
		UserDao sqlBean = new UserDao();
		sqlBean.addUser(u);
		//流程跳转,大多数的流程调转也是跳转到另一个
		//servlet，很少直接调转到另一个jsp
		//UserListServlet我们创建
		response.sendRedirect("LoginServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
