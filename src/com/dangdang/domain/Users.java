package com.dangdang.domain;
/**
 * �������û����г��󣬱�ʾϵͳ�ڵ��û���Ϣ��һ����������
 * ����user����е�������һ�µģ����user��������
 * ��ô������Ӧ�����ĸ����ԣ������һ�ж�Ӧһ������
 * һ��һ�������ж����оͿ��Է�װ�����ٸ�����
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
	


