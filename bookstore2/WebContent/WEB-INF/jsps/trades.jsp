<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<br> <br>
		<h4>User: ${user.username }</h4>
		<br> <br>
		<s:iterator value="#user.trades" var="trade">
			<tr>
				<td>
					<table border="1" cellpadding="10" cellspacing="0">

						<tr>
							<td colspan="3">TradTime: ${trade.tradeTime }</td>
						</tr>

						<s:iterator value="#trade.items" var="item">
							<tr>
								<td>${item.book.title }</td>
								<td>${item.book.price }</td>
								<td>${item.quantity }</td>
							</tr>
						</s:iterator>

					</table> <br> <br>
				</td>
			</tr>

		</s:iterator>
	</center>
</body>
</html>