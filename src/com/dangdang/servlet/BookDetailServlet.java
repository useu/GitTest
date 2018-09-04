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
		// ��ȡ����
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		// ��װ����
		Book book = new Book();
		book.setId(id);
		// book��ʵ�Σ��������id
		// b�Ƿ����ķ���ֵ����������������Ϣ
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
