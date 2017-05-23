package com.hsw.bookstore.dao;

import com.hsw.bookstore.domain.User;

public interface UserDao {

	/**
	 * 根据用户名获取 User 对象
	 * @param username
	 * @return
	 */
	public  User getUser(String username);

}

