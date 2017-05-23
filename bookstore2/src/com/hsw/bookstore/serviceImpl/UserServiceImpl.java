package com.hsw.bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsw.bookstore.dao.UserDao;
import com.hsw.bookstore.domain.User;
import com.hsw.bookstore.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserByUserName(String username) {
		return userDao.getUser(username);
	}

}
