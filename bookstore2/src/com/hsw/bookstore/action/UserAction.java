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

	// ��֤���
	public void validateDetails() {
		// ��֤�û����Ƿ�Ϊ��
		username = username.trim();
		if (username == null || "".equals(username)) {
			addFieldError("username", "�û���������Ϊ�գ�");
		}

		// ��֤�˻��Ƿ�ƥ��
		User user = userService.getUserByUserName(username);
		if (user == null) {
			addActionError("���û�������!");
		}
	}

}
