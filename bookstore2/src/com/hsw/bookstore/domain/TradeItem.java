package com.hsw.bookstore.domain;

public class TradeItem {

	private Long id;
	
	//�����Ķ���
	private Trade trade;
	
	//�� TradeItem ������ Book
	private Book book;
	//�������
	private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
	
	
	

}
