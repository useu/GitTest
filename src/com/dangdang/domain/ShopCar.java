package com.dangdang.domain;
//jsp��Ϊ���֣���1���û��ӿ� ��2����ʾ���� 
//��½��ע�����û��ӿڲ���Ҫ��ִ��servlet
//ͼ���б�ͼ����������ʾ���ݵģ�
//����������servlet����û������ 


public class ShopCar {
	// ʵ�����ж��ٸ����ԣ��ɱ����ж��ٸ��ֶξ���
	private int id;
	// �������һ���������userid����ô����ֶ�һ����
	// �������ʾ��ʵ��������ͣ�������int����
	// �����������еı�ʵ��
	private Users user;// ��ǰ������ﳵ�������ĸ��û�
	private Book book;// ��ǰ���ﳵ��������ı���
	private int count;// ������飬���˼���

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
