package com.hsw.bookstore.domain;

import java.util.Date;


public class Book {
	
	private Long id;
	private String author;
	
	private String title;
	private float price;
	
	private Date publishingDate;
	private int salesAmount;
	
	private int storeNumber;
	private String remark;
	
	//关联的订单项
	private TradeItem tradeItem;
	
	public TradeItem getTradeItem() {
		return tradeItem;
	}
	public void setTradeItem(TradeItem tradeItem) {
		this.tradeItem = tradeItem;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	public int getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
	
	
	
	
		
}
