package com.hsw.bookstore.service;

import java.util.List;

import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCart;

public interface BookService {
	
	void save(Book book);
	//ɾ��
	void delete(Book book);
	//�޸�
	void update(Book book);
	//��ѯ����
	List<Book> getAll();
	//ͨ��id ��ѯ
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
