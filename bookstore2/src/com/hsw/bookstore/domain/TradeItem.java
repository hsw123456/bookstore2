package com.hsw.bookstore.domain;

public class TradeItem {

	private Long id;
	
	//关联的订单
	private Trade trade;
	
	//和 TradeItem 关联的 Book
	private Book book;
	//书的数量
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
