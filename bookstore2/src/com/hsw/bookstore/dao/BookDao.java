package com.hsw.bookstore.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCartItem;

@Transactional
public interface BookDao extends BaseDao<Book> {

	List<Book> getAll(Integer pageNum, Integer pageCount);

	long getCount();

	List<Book> getAll(Integer pageNum, Integer pageCount, QueryModel qm);

	long getCount(QueryModel qm);

	void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);
	

}
