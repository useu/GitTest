<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>当当网-数据结构与算法分析(java语言描述)</title>
<link href="css/page_03.css" rel="stylesheet" type="text/css"
	media="all" />
<script>
	function cartDetail() {
		document.getElementById("cartDetail").submit();
	}
</script>
</head>
<body>

	<div id="wrapper">
		=
		<!-- header 部分 -->
		<div id="header">
			<!-- 登录信息 -->
			<div id="information">
				<span>您好，</span><a href="###">爱淘淘</a> <a href="###" class="exit">[退出登录]</a>
			</div>
			<!-- 登录信息 END -->
		</div>
		<!-- header 部分 -->

		<div id="content_01"></div>

		<!-- content_02 部分 -->


		<form action="CartDetailsServlet" id="cartDetail" method="post">


			<table align="center" border=1>

	<!-- bookDetail
	    addCart
	    cartList
	    addCart和cartList
	    cart数据添加到item里，然后添加数据到order表里面
     -->

				<tr>
					<td align="center" width="248">商品名称</td>
					<td align="center" width="183">商品积分</td>
					<td align="center" width="199">当当价</td>
					<td align="center" width="190">数量</td>
					<td align="center" width="134">操作</td>
				</tr>
				<c:forEach items="${list }" var="cart">
					<tr>
						<td align="center"><img src="cover/suanfa.jpg" height="230"
							width="230"> ${cart.book.name }</td>
						<td align="center">10</td>

						<td align="center">100 
						<input name="cartDetails" value="${cart.id }_${cart.book.id}_${cart.count}" type="hidden" />
						</td>
						<td align="center">
						${cart.count} 
							<!--购买数量 --></td>
						<td align="center"><a href="DeleteCartServlet?id=${cart.id}">删除</a></td>
					</tr>
				</c:forEach>

			</table>

			<p align="right">
				<!-- 商品金额总计 -->
				<span>商品金额总计￥：1000</span>

			</p>



			<!-- 继续购物 -->
			<div id="goBuy">
				<div align="right">
					<a href="BookListServlet"><img src="images/Page_03_03_buy.jpg"
						alt="" border="0" /></a>
				</div>
			</div>

			<div align="right">
				<!-- 结算按钮 -->
				<a onclick="cartDetail();"><img src="images/Page_03_solve.jpg"
					alt="" border="0" /></a>
			</div>

			<!-- content_03 部分 -->
			<div id="content_03"></div>
			<!-- footer 部分 -->
			<div id="footer"></div>
	</div>
	</form>
</body>
</html>

