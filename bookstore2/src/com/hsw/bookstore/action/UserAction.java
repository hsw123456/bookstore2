package com.hsw.bookstore.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsw.bookstore.domain.User;
import com.hsw.bookstore.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class UserAction extends ActionSupport {

	private String username ="";
	@Autowired
	private UserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String details() {

		User user = userService.getUserByUserName(username);
		ActionContext.getContext().put("user", user);
		return "details";
	}

	// 验证框架
	public void validateDetails() {
		// 验证用户名是否为空
		username = username.trim();
		if (username == null || "".equals(username)) {
			addFieldError("username", "用户姓名不能为空！");
		}

		// 验证账户是否匹配
		User user = userService.getUserByUserName(username);
		if (user == null) {
			addActionError("该用户不存在!");
		}
	}

}
