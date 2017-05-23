package com.hsw.bookstore.service;

import java.util.List;

import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCart;

public interface BookService {
	
	void save(Book book);
	//删除
	void delete(Book book);
	//修改
	void update(Book book);
	//查询所有
	List<Book> getAll();
	//通过id 查询
	Book getById(Long id);
	
	List<Book> getAll(Integer pageNum, Integer pageCount);
	
	long getCount();
	
	List<Book> getAll(Integer pageNum, Integer pageCount, QueryModel qm);
	
	long getCount(QueryModel qm);
	
	boolean addToCart(long id, ShoppingCart sc);
	
    void clearShoppingCart(ShoppingCart sc);
    
	void removeItemFromShoppingCart(ShoppingCart sc, Long id);
	
	void cash(ShoppingCart shoppingCart, String username, String accountId);

}
