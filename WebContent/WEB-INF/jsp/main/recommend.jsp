<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	<c:forEach items="${recommendBooks }" var="recommendbook">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href="<%=basePath%>main/book_view?id=${recommendbook.id }" ><img src="<%=basePath%>productImages/${recommendbook.product.product_pic }" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href="<%=basePath%>/main/book_view?id=${recommendbook.id }" title='${recommendbook.product.product_name }'>书名:${recommendbook.product.product_name }</a>
				</h3>
				<h4>
					作者：${recommendbook.author } 著
					<br />
					出版社：${recommendbook.publishing }&nbsp;&nbsp;&nbsp;&nbsp;出版时间：${recommendbook.publish_dt }
				</h4>
				<h5>
					简介:${recommendbook.product.description }
				</h5>
				<h6>
					定价：￥${recommendbook.product.fixed_price }&nbsp;&nbsp;当当价：￥${recommendbook.product.dang_price }
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		
	</div>
</div>
