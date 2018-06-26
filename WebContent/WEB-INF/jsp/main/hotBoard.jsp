<%@ page langua"WebContent/WEB-INF/jsp/main/book_list.jsp"ge="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- <h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">-->
<div><ul>
	<c:forEach items="${newHotBooks }" var="newHotBook">
	<li >
		<div align="center">
			<a href="<%=basePath%>main/book_view?id=${newHotBook.id }" ><img
					src="<%=basePath%>productImages/${newHotBook.product.product_pic }" border=0 width="120px" /> </a>
		</div>
		<li class="shuming">
			<a href="<%=basePath%>book_view?id=${newHotBook.id }" >${newHotBook.product.product_name }</a><a href="#" target="_blank"></a>
		</li>
		<li class="price">
			定价：￥${newHotBook.product.fixed_price }
		</li>
		<li class="price">
			当当价：￥${newHotBook.product.dang_price }
		</li>
	</li>
	<li class="book_c_xy_long"></li>
	</c:forEach>
</ul>
</div>
	<!-- <h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div> -->