<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
</head>
<body>

	
	<center>
		<s:iterator value="#book">
			Title: ${title}
			<br><br>
			Author: ${author }
			<br><br>
			Price: ${price }
			<br><br>
			PublishingDate: ${publishingDate }
			<br><br>
			Remark: ${remark }
		</s:iterator>
		<s:a>
			继续购物
			<s:param name="pageNum" value="pageNum"/>
		</s:a>
		
	</center>
	
</body>
</html>