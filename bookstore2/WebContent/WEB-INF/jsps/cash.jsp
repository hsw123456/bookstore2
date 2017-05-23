<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<center>
		<br><br>
		您一共买了 ${shoppingCart.bookNumber } 本书
		<br>
		应付: ￥ ${ shoppingCart.totalMoney}
		<br><br>
	<!--  
		<c:if test="${requestScope.errors != null }">
			<font color="red">${requestScope.errors }</font>
		</c:if>
	-->
	<s:fielderror />
	<s:actionerror/>	
	<s:form action="bookstore_cash.action">
			<table cellpadding="10"> 
				<tr>
					<td>用户姓名:</td>
					<td><s:textfield name="username"/></td>
				</tr>
				<tr>
					<td>信用卡账号:</td>
					<td><s:textfield name="accountId"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit value="提交"></s:submit>
					</td>
				</tr>
			</table>
	</s:form>
	</center>
</body>
</html>