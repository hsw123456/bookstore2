package com.hsw.bookstore.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Trade {

	//Trade 对象对应的 id
	private Long id;
	//交易的时间
	private Date tradeTime;
	
	//关联的USer
	private User user;
	//Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new HashSet<>();
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public Set<TradeItem> getItems() {
		return items;
	}
	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", tradeTime=" + tradeTime + ", user="
				+ user + "]";
	}
	
	
	
	
	

	
}

