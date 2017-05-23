package com.hsw.bookstore.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {

	private Long id;
	private String username;
	private Set<Trade> trades = new HashSet<>();
	
	//用户与账户的多对一关联关系
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Set<Trade> getTrades() {
		return trades;
	}
	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	
}
