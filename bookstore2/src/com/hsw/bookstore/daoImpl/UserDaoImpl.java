package com.hsw.bookstore.daoImpl;

import org.hibernate.Query;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.hsw.bookstore.dao.UserDao;
import com.hsw.bookstore.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUser(String username) {
		
		String hql = "FROM User u WHERE u.username = ?";
		Query query = getSession().createQuery(hql).setParameter(0, username);
		
		User user = (User) query.uniqueResult();
		
		return (User) getSession().load(User.class, user.getId());
		
		
													
				
	}
	
	

}
