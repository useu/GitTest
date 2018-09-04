package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.BookDao;
import com.dangdang.dao.CarDao;
import com.dangdang.dao.OrderDao;
import com.dangdang.dao.TypeDao;
import com.dangdang.domain.Book;
import com.dangdang.domain.Booktype;
import com.dangdang.domain.Order;



public class AddOderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddOderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String sub = request.getParameter("sub");
		String tel = request.getParameter("tel");
		System.out.println(name);
		System.out.println(address);
		System.out.println(sub);
		System.out.println(tel);
		Order o = new Order();
		o.setAddress(address);
		o.setSub(sub);
		o.setName(name);
		o.setTel(tel);

		OrderDao dao = new OrderDao();
		int orderId = dao.addOrder(o);
		HttpSession session = request.getSession();
		BookDao bdao = new BookDao();
		String[] carts = (String[]) session.getAttribute("carts");
		CarDao cdao = new CarDao();

		for (String s : carts) {
			// cartid bookid count
			String[] detail = s.split("_");
			int cartid = Integer.parseInt(detail[0]);
			int bookid = Integer.parseInt(detail[1]);
			int count = Integer.parseInt(detail[2]);
			Book book = bdao.getBookById(bookid);
			TypeDao idao = new TypeDao();
			Booktype bt = new Booktype();
			bt.setBook(book);
			bt.setBookName(book.getName());
			bt.setCount(count);
			bt.setOrderId(orderId);
			bt.setPrice(book.getPrice());
			idao.addItem(bt);
			cdao.delCart(cartid);
		}

		//
		response.sendRedirect("pay.jsp");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
