package com.hsw.bookstore.daoImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hsw.bookstore.dao.AccountDao;
import com.hsw.bookstore.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	@Override
	public Account get(Long accountId) {
		return getById(accountId);
	}

	@Override
	public void updateBalance(Long accountId, float amount) {
		String hql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.id = ?";
		Query query = getSession().createQuery(hql)//
								  .setParameter(0, amount)//
								  .setParameter(1, accountId);
		query.executeUpdate();
	}



}
