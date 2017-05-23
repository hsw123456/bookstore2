<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/commons/common.jsp" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		var maxPageNum = ${maxPageNum};
		var pageNum = ${pageNum};
		//1.最大页等于1都隐藏
		if(maxPageNum == 1){
		$("#fir").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","none");
		$("#last").css("display","none");
		//2.第一页前2隐藏后二显示
		}else if(pageNum == 1){
		$("#fir").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","inline");
		$("#last").css("display","inline");
		//3.最后一页前二显示后二隐藏
		}else if(pageNum == maxPageNum){
		$("#fir").css("display","inline");
		$("#pre").css("display","inline");
		$("#next").css("display","none");
		$("#last").css("display","none");
		//4.中间都显示
		}else{
		$("#fir").css("display","inline");
		$("#pre").css("display","inline");
		$("#next").css("display","inline");
		$("#last").css("display","inline");
			
		}
		
		$("#fir").click(function(){
			//收集页码值，把页码值设置为指定值:$("[name='pageNum']").val()*1+1
			$("[name='pageNum']").val(1);
			//提交表单
			$("form:first").submit();
		});
		
		$("#next").click(function(){
			//收集页码值，把页码值设置为指定值:$("[name='pageNum']").val()*1+1
			$("[name='pageNum']").val($("[name='pageNum']").val()*1+1);
			//提交表单
			$("form:first").submit();
		});
		
		$("#pre").click(function(){
			//收集页码值，把页码值设置为指定值:$("[name='pageNum']").val()*1+1
			$("[name='pageNum']").val($("[name='pageNum']").val()-1);
			//提交表单
			$("form:first").submit();
		});
		$("#last").click(function(){
			//收集页码值，把页码值设置为指定值:$("[name='pageNum']").val()*1+1
			$("[name='pageNum']").val(${maxPageNum});
			//提交表单
			$("form:first").submit();
		});
		
	})
	
</script>
</head>
<body>
	
	<center>
	<!--  
		 <c:if test="${param.title != null}">
			您已经将 ${param.title} 放入到购物车中. 
			<br><br>
		</c:if> 
		
		
		
		<c:if test="${!empty sessionScope.ShoppingCart.books }">
			您的购物车中有 ${sessionScope.ShoppingCart.bookNumber } 本书, <a href="bookServlet?method=forwardPage&page=cart&pageNo=${bookpage.pageNo }">查看购物车</a>
		</c:if>
		
		<br><br>
		
		
	-->
	
		<s:if test="title != null">
			您已经将 ${title} 放入到购物车中. 
			<br><br>
		</s:if>
		
		<s:if test="#session.shoppingCart.books != null">
			您的购物车中有 ${shoppingCart.bookNumber} 本书，
			<a href="bookstore_toCartPage?pageNum=${pageNum }">查看购物车</a>
		</s:if>
		
		
		<s:form action="bookstore_list.action">
			Price:
			<s:textfield name="qm.minPrice" size="2" /> -
			<s:textfield name="qm.maxPrice" size="2" /> 
			<s:submit />
	 		<table cellpadding="10">
				<s:iterator value="#bookList">
					<tr>
						<td>
							<s:a action="bookstore_details.action">${title }
								<s:param name="id"  value="id"/>
							</s:a>
							<td>${author }</td>
						</td>
						<td>${price }</td>
						<td>
						<s:a action="bookstore_addToCart.action">
						加入购物车
						<s:param name="id" value="id"/>
						<s:param name="title" value="title"/>
						<s:param name="pageNum" value="pageNum"/>
						</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		<s:hidden  name="pageNum" />	
			第 ${pageNum }页/共${maxPageNum }页
			&nbsp;
			<a id="fir">首页</a>
			&nbsp;
			<a  id="pre">上一页</a>
			&nbsp;
			<a id="next">下一页</a>
			&nbsp;
			<a  id="last">末页</a>
			&nbsp;
		转到 <input type="text" size="1" id="pageNo"/>页	
	</s:form>	
			
	</center>
	
</body>
</html>