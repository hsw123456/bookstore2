package com.hsw.bookstore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hsw.bookstore.dao.BookDao;
import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCartItem;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public List<Book> getAll(Integer pageNum, Integer pageCount) {

		Query query = getSession().createQuery("FROM Book")
				//
				.setFirstResult((pageNum - 1) * pageCount)
				.setMaxResults(pageCount);
		return query.list();
	}

	@Override
	public long getCount() {

		String hql = "SELECT COUNT(id) FROM Book";
		Query query = getSession().createQuery(hql);
		return (long) query.uniqueResult();
	}

	@Override
	public List<Book> getAll(Integer pageNum, Integer pageCount, QueryModel qm) {

		String hql = "FROM Book b WHERE b.price>=? AND b.price<=?";

		Query query = getSession()
				.createQuery(hql)
				//
				.setParameter(0, qm.getMinPrice())
				.setParameter(1, qm.getMaxPrice())
				.setFirstResult((pageNum - 1) * pageCount)
				.setMaxResults(pageCount);

		return query.list();
	}

	@Override
	public long getCount(QueryModel qm) {
		String hql = "SELECT COUNT(id) FROM Book b WHERE b.price>=? AND b.price<=?";
		Query query = getSession().createQuery(hql)//
				.setParameter(0, qm.getMinPrice())//
				.setParameter(1, qm.getMaxPrice());//

		return (long) query.uniqueResult();
	}


	@Override
	public void batchUpdateStoreNumberAndSalesAmount(
			Collection<ShoppingCartItem> items) {
		
		String hql = "UPDATE Book SET salesAmount = salesAmount + ?"+
				",storeNumber = storeNumber-? " +
				"WHERE id = ?";
		// hibernate 做批量操作建议使用jdbc 原生的jdbcAPI 来操作，速度更快
			for(ShoppingCartItem sci: items){
				Query query = getSession().createQuery(hql)//
										  .setParameter(0, sci.getQuantity())//
										  .setParameter(1, sci.getQuantity())//
										  .setParameter(2, sci.getBook().getId());
				query.executeUpdate();
			}
		

	}

}
