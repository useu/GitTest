package com.dangdang.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.BookDao;
import com.dangdang.domain.Book;


public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String c = request.getParameter("currentPage");
		if (c == null) {
			c = "1";
		}
		int currentPage = Integer.parseInt(c);
		BookDao bookDao = new BookDao();
		int totalCount = bookDao.bookCount();
		System.out.println("count = " + totalCount);
		int pageSize = 10;
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		List<Book> list = bookDao.bookList(currentPage, pageSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/bookList.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
