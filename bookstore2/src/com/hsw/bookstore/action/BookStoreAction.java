package com.hsw.bookstore.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsw.bookstore.domain.Account;
import com.hsw.bookstore.domain.Book;
import com.hsw.bookstore.domain.QueryModel;
import com.hsw.bookstore.domain.ShoppingCart;
import com.hsw.bookstore.domain.ShoppingCartItem;
import com.hsw.bookstore.domain.User;
import com.hsw.bookstore.service.AccountService;
import com.hsw.bookstore.service.BookService;
import com.hsw.bookstore.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class BookStoreAction extends ActionSupport {
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BookService bookService;
	
	public Integer pageNum = 1;
	public Integer pageCount = 5;
	public Long id;
	public String title;
	// 保存最大页码数
	public Long maxPageNum ; 
	public QueryModel qm = new QueryModel();
	
	public String list() throws Exception{
		
		//获取数据库中数据的总条数
		//long count = bookService.getCount();
		long count = bookService.getCount(qm);
		maxPageNum = (count + pageCount-1)/pageCount;
		//List<Book> bookList = bookService.getAll();
		//List<Book> bookList = bookService.getAll(pageNum,pageCount);
		List<Book> bookList = bookService.getAll(pageNum,pageCount,qm);
		ActionContext.getContext().put("bookList", bookList);
		return "list";
	}
	
	
	public String details() throws Exception{
		Book book = bookService.getById(id);
		ActionContext.getContext().put("book", book);
		//ActionContext.getContext().put("pageNum", pageNum);
		return "book";
	}
	
	public String addToCart() throws Exception{
		Book book = bookService.getById(id);
		boolean flag = false;
		if(book != null){
			ShoppingCart sc = getShoppingCart();
			flag = bookService.addToCart(id, sc);
		}
		if(flag){
			//4. 直接调用 getBooks() 方法. 
			return "toList";
		}
		
		return "error-1";
	}
	
	public String toCartPage()throws Exception{
		
		return "cart";
	}
	
	public String removeItem()throws Exception{
		ShoppingCart sc = getShoppingCart();
		bookService.removeItemFromShoppingCart(sc, id);
		
		if(sc.isEmpty()){
			return "emptycart";
		}
		
		return "cart";
	}
	
	public String clearCart()throws Exception{
		
		ShoppingCart sc = getShoppingCart();
		bookService.clearShoppingCart(sc);
		return "emptycart";
	}
	
	public String toCash() throws Exception{
		return "cash";
	}
	
	
	public String username ;
	public String accountId ;
	
	public String cash() throws Exception{
		
		Long account = 0L;
		try {
			
			username = username.trim();
			account = Long.parseLong(accountId.trim());
			User user = userService.getUserByUserName(username);
			Long accountNumber = user.getAccount().getId();
			bookService.cash(getShoppingCart(), username, accountId); 
			
		} catch (Exception e) {
		}
		//验证通过执行具体的逻辑操作
		return "success";
	}
	
	
	/*public void validateCash(){
		username = username.trim();
		accountId = accountId.trim();
		//验证用户名和账户是否为空
		if(username == null || "".equals(username)){
			addFieldError("username", "用户姓名不能为空！");
		}
		if(accountId == null || "".equals(accountId)){
			addFieldError("accountId", "信用卡账户不能为空！");
		}
		//验证账户是否匹配
		User user = userService.getUserByUserName(username);
		if(user != null){
			long accountId2 = user.getAccount().getId();
			if(!(accountId.trim().equals("" + accountId2))){
				addActionError("用户名和账户不匹配！");
			}
		}
		
		//验证库存是否充足！
		ShoppingCart cart = getShoppingCart();
		for(ShoppingCartItem sci: cart.getItems()){
			int quantity = sci.getQuantity();
			int storeNumber = bookService.getById(sci.getBook().getId()).getStoreNumber();
			if(quantity > storeNumber){
				//errors.append(sci.getBook().getTitle() + "库存不足<br>");
				addActionError(sci.getBook().getTitle()+"库存不足");
			}
		}
		//验证余额是否足够
		//TODO:Interger.parseInt(accountId):可能产生异常
		long accoutNumber = 0L;
		try {
			accoutNumber = Long.parseLong(accountId);
			Account account = accountService.getAccount(accoutNumber);
			if(cart.getTotalMoney() > account.getBalance()){
				addActionError("账户余额不足！");
			}
		} catch (Exception e) {}
		
	}*/
	
	
	//====================================================
	
	public static ShoppingCart getShoppingCart(){
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		ShoppingCart sc = (ShoppingCart) session.get("shoppingCart");
		if(sc == null){
			sc = new ShoppingCart();
			session.put("shoppingCart", sc);
		}
		
		return sc;
	}
	
	

}
