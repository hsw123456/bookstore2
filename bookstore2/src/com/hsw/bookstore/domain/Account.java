package com.hsw.bookstore.domain;

import java.util.HashSet;
import java.util.Set;


public class Account {

	private Long id;
	private float balance;
	
	//ӳ���˻����û���һ�Զ��ϵ
	
	private Set<User> users = new HashSet<>();
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	
	

}
