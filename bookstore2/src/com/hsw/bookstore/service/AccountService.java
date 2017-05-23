package com.hsw.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsw.bookstore.dao.AccountDao;
import com.hsw.bookstore.domain.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;	
	
	public Account getAccount(long accountId){
		
		return accountDao.get(accountId);
	}
	
}
