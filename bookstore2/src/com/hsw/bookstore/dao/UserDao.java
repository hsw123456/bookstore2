package com.hsw.bookstore.dao;

import com.hsw.bookstore.domain.User;

public interface UserDao {

	/**
	 * �����û�����ȡ User ����
	 * @param username
	 * @return
	 */
	public  User getUser(String username);

}

