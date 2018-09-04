package com.dangdang.domain;
//jsp分为两种：（1）用户接口 （2）显示数据 
//登陆和注册是用户接口不需要先执行servlet
//图书列表、图书详情是显示数据的，
//必须先运行servlet否则没有数据 


public class ShopCar {
	// 实体类有多少个属性，由表中有多少个字段决定
	private int id;
	// 如果表有一个外键例如userid，那么这个字段一般是
	// 外键所表示的实体类的类型，而不是int类型
	// 上面规则对所有的表都实用
	private Users user;// 当前这个购物车项属于哪个用户
	private Book book;// 当前购物车放入的是哪本书
	private int count;// 上面的书，放了几本

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
