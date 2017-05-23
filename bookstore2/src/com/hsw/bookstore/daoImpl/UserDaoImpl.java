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
		String hql = "select DISTINCT  u.* From tbl_user u,tbl_trade t,"
					+ "tbl_tradeitem i, tbl_book b "
					+" where u.id = t.userid "+
					 "  AND i.tradeid = t.id"+
					 "  AND i.bookid = b.id"+
					 "  AND u.user_name=?";
		Query query = getSession().createSQLQuery(hql).setParameter(0,username);
		
		
		return null;
													
				
	}
	
	

}
