<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${newBooks }" var="newBook">
	<div class="second_d_wai">
		<div class="img">
			<a href="<%=basePath%>main/book_view?id=${newBook.id}"><img
					src="<%=basePath%>productImages/${newBook.product.product_pic}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="<%=basePath%>main/book_view?id=${newBook.id}" >${newBook.product.product_name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${newBook.product.fixed_price}
		</div>
		<div class="price">
			当当价：￥${newBook.product.dang_price}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>