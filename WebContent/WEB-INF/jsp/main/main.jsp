<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="<%=basePath%>css/book.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/second.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/secBook_Show.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	、&nbsp;
	<!-- 头部开始 -->
	<%@include file="/common/head.jsp"%>
	<!-- 头部结束 -->
	<div style="width: 962px; margin: auto;">
		<a href="#" target="_blank"><img
			src="<%=basePath%>images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<!-- <s:action name="categoryAction" namespace="/main" executeResult="true"></s:action> -->
			<%-- <c:import
				url="<%=basePath%>main/categoryAction"></c:import> --%>
			<div class="book_l_border1" id="__FenLeiLiuLan">
				<div class="book_sort_tushu">
					<h2>分类浏览</h2>

					<c:forEach items="${cats }" var="c1">
						<!--1级分类开始-->
						<div class="bg_old" onmouseover="this.className = 'bg_white';"
							onmouseout="this.className = 'bg_old';">
							<h3>
								[<a href='#'>${c1.name }</a>]
							</h3>
							<ul class="ul_left_list">

								<c:forEach items="${c1.subCats }" var="c2">
									<!--2级分类开始-->
									<li><a
										href='<%=basePath%>main/booklistAction?c1=${c1.id }&c2=${c2.id }'>${c2.name}</a>
									</li>
									<!--2级分类结束-->
								</c:forEach>

							</ul>

							<div class="empty_left"></div>
						</div>

						<div class="more2"></div>
						<!--1级分类结束-->
					</c:forEach>

					<div class="bg_old">
						<h3>&nbsp;</h3>
					</div>
				</div>
			</div>

		</div>
		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--推荐图书开始-->
			<div class=second_c_border1 id="recommend">
				<!-- <s:action name="recommendAction" namespace="/main" executeResult="true"></s:action> -->
				<%-- <c:import
					url="<%=basePath%>mian/recommendAction"></c:import> --%>
					<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	<c:forEach items="${recommendBooks }" var="recommendbook">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href="<%=basePath%>main/book_view?id=${recommendbook.id }" >
				<img src="${pageContext.request.contextPath }/productImages/${recommendbook.product.product_pic }" width=70 border=0 /> </a>
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
					
			</div>

			<!--推荐图书结束-->

			<!--热销图书开始-->
			<div class="book_c_border2" id="hot">
				<!-- <s:action name="hotAction" namespace="/main" executeResult="true"></s:action> -->
				<%-- <c:import url="<%=basePath%>main/hotAction"></c:import> --%>
				<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a>
					</span>热销图书
				</h2>
				<div class="book_c_04">

					<!--热销图书A开始-->
					<c:forEach items="${hotBooks }" var="hotbook" varStatus="hotbook">
						<div class="second_d_wai">
							<div class="img">
								<a href="<%=basePath%>main/book_view?id=${hotbook.id }">
								<img
									src="${pageContext.request.contextPath }/productImages/${hotbook.product.product_pic }"
									border=0 /> </a>
							</div>
							<div class="shuming">
								<a href='<%=basePath%>main/book_view?id=${hotbook.id }'>${hotbook.product.product_name }</a><a
									href="#" target="_blank"></a>
							</div>
							<div class="price">定价：￥${hotbook.product.fixed_price }</div>
							<div class="price">当当价：￥${hotbook.product.dang_price }</div>
						</div>
						<div class="book_c_xy_long">hotBooks</div>
					</c:forEach>
					<!--热销图书A结束-->

				</div>
			</div>
			<!--热销图书结束-->

			<!--最新上架图书开始-->
			<div class="book_c_border2" id="new">
				<!-- <s:action name="newAction" namespace="/main" executeResult="true"></s:action> -->
				<%-- <c:import url="<%=basePath%>main/newAction"></c:import> --%>
				<h2>
					<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a>
					</span>最新上架图书
				</h2>
				<div class="book_c_04">

					<!--热销图书A开始-->
					<c:forEach items="${newBooks }" var="newBook">
						<div class="second_d_wai">
							<div class="img">
								<a href="<%=basePath%>main/book_view?id=${newBook.id }"><img
									src="<%=basePath%>productImages/${newBook.product.product_pic }"
									border=0 /> </a>
							</div>
							<div class="shuming">
								<a href="<%=basePath%>main/book_view?id=${newBook.id }">${newBook.product.product_name }</a><a
									href="#" target="_blank"></a>
							</div>
							<div class="price">定价：￥${newBook.product.fixed_price }</div>
							<div class="price">当当价：￥${newBook.product.dang_price }</div>
						</div>
						<div class="book_c_xy_long">newBooks</div>
					</c:forEach>
					<!--热销图书A结束-->

				</div>
				<div class="clear"></div>
			</div>

			<!--最新上架图书结束-->

			<div class="clear"></div>
		</div>
		<!--中栏结束-->



		<!--右栏开始-->
		<div class="book_right">
			<div class="book_r_border2" id="__XinShuReMai">
				<div class="book_r_b2_1x" id="new_bang">
					<h2 class="t_xsrm">新书热卖榜</h2>
					<div id="NewProduct_1_o_t" onmouseover="">
						<!-- <s:action name="newHotAction" namespace="/main" executeResult="true"></s:action> -->
						<%-- <c:import
							url="<%=basePath%>main/newHotAction"></c:import>
						 --%><div>
							<ul>
								<c:forEach items="${newHotBooks }" var="newHotBook"
									varStatus="newHotBook">
									<li>
										<div align="center">
											<a
												href="<%=basePath%>main/book_view?id=${newHotBook.id }">
												<img
												src="<%=basePath%>productImages/${newHotBook.product.product_pic }"
												border=0 width="120px" /> </a>
										</div>
										<li class="shuming"><a
											href="<%=basePath%>book_view?id=${newHotBook.id }">${newHotBook.product.product_name }</a><a
											href="#" target="_blank"></a></li>
										<li class="price">定价：￥${newHotBook.product.fixed_price }
									</li>
										<li class="price">当当价：￥${newHotBook.product.dang_price }
									</li>
									</li>
									<li class="book_c_xy_long"></li>
								</c:forEach>
							</ul>
						</div>
						<h3 class="second">
							<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
						</h3>
					</div>
				</div>
			</div>
		</div>
		<!--右栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="/common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>
