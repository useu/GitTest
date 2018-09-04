package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.BookDao;
import com.dangdang.domain.Book;

public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		// 封装对象
		Book book = new Book();
		book.setId(id);
		// book是实参，包含书的id
		// b是方法的返回值，包含了书所有信息
		BookDao dao = new BookDao();
		Book b = dao.bookDetail(book);
		request.setAttribute("book", b);
		request.getRequestDispatcher("/bookDetail.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
