package com.hsw.bookstore.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsw.bookstore.dao.AccountDao;
import com.hsw.bookstore.dao.BookDao;
import com.hsw.bookstore.dao.TradeDao;
import com.hsw.bookstore.dao.TradeItemDao;
import com.hsw.bookstore.dao.UserDao;
import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCart;
import com.hsw.bookstore.domain.ShoppingCartItem;
import com.hsw.bookstore.domain.Trade;
import com.hsw.bookstore.domain.TradeItem;
import com.hsw.bookstore.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private TradeDao tradeDao;
	@Autowired
	private TradeItemDao tradeItemDao;

	@Override
	public void save(Book book) {
		bookDao.save(book);
	}

	//
	@Override
	public void delete(Book book) {
		bookDao.delete(book);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	@Override
	public Book getById(Long id) {
		return bookDao.getById(id);
	}

	@Override
	public List<Book> getAll(Integer pageNum, Integer pageCount) {
		return bookDao.getAll(pageNum, pageCount);
	}

	@Override
	public long getCount() {
		return bookDao.getCount();
	}

	@Override
	public List<Book> getAll(Integer pageNum, Integer pageCount, QueryModel qm) {
		return bookDao.getAll(pageNum, pageCount, qm);
	}

	@Override
	public long getCount(QueryModel qm) {
		return bookDao.getCount(qm);
	}

	@Override
	public boolean addToCart(long id, ShoppingCart sc) {
		Book book = bookDao.getById(id);
		if (book != null) {
			sc.addBook(book);
			return true;
		}

		return false;
	}

	@Override
	public void clearShoppingCart(ShoppingCart sc) {
		sc.clear();
	}

	@Override
	public void removeItemFromShoppingCart(ShoppingCart sc, Long id) {
		sc.removeItem(id);
	}

	@Override
	public void cash(ShoppingCart shoppingCart, String username,
			String accountId){

		// 1. 更新 books 数据表相关记录的 salesamount 和 storenumber
		bookDao.batchUpdateStoreNumberAndSalesAmount(shoppingCart.getItems());
		
		// 2. 更新 account 数据表的 balance
		//TODO
		Long accountNumber = 0L;
		
		try {
			accountNumber = Long.parseLong(accountId);
			accountDao.updateBalance(accountNumber,shoppingCart.getTotalMoney() );
			
		} catch (Exception e) {}
		
		// 3. 向 trade 数据表插入一条记录
		Trade trade = new Trade();
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		trade.setUser(userDao.getUser(username));
		tradeDao.insert(trade);
		
		// 4. 向 tradeitem 数据表插入 n 条记录
		Collection<TradeItem> items = new ArrayList<>();
		for(ShoppingCartItem sci: shoppingCart.getItems()){
			TradeItem tradeItem = new TradeItem();
			
			tradeItem.setBook(sci.getBook());
			tradeItem.setQuantity(sci.getQuantity());
			tradeItem.setTrade(trade);
			
			items.add(tradeItem);
		}
		
		tradeItemDao.batchSave(items);
		
		// 5. 清空购物车
		shoppingCart.clear();
	}

}
