package com.dangdang.domain;
/**
 * 用来对用户进行抽象，表示系统内的用户信息，一共三个属性
 * 跟表user表的列的数量是一致的，如果user表有四列
 * 那么这个类就应该有四个属性，表里的一行对应一个对象
 * 一行一个对象，有多少行就可以封装出多少个对象
 * @author root
 *
 */
public class Users {
	public Users()
	{
	}
	
	public Users(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public Users(int id, String email, String name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
	}
	private int id;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	}
	


