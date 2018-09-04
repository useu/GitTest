<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>当当网-名社新书大PK</title>
<link href="css/page_01.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
  	<!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="###" >爱淘淘</a> <a href="###" class="exit">[退出登录]</a>
        <!-- 搜索 -->
        <div class="search">
        <input class="searchInput" type="text" /><input type="button" class="searchBtn" />
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END-->
  </div><!-- header END -->
  
  <div id="banner"></div>
  
  <!-- content 部分 -->
  <div id="content">
  	<!-- 图书商品分类 -->
  	<div class="content-left">
    	<ul>
        	<li><a href="###">计算机/网络</a><span>（1213）</span></li>
            <li><a href="###">医学</a><span>（1213）</span></li>
            <li><a href="###">建筑</a><span>（1213）</span></li>
            <li><a href="###">烹饪/美食</a><span>（1213）</span></li>
            <li><a href="###">管理</a><span>（1213）</span></li>
            <li><a href="###">社会科学</a><span>（1213）</span></li>
            <li><a href="###">心理学</a><span>（1213）</span></li>
            <li><a href="###">法律</a><span>（1213）</span></li>
            <li><a href="###">政治/军事</a><span>（1213）</span></li>
            <li><a href="###">传记</a><span>（1213）</span></li>
            <li><a href="###">古籍</a><span>（1213）</span></li>
            <li><a href="###">文化</a><span>（1213）</span></li>
            <li><a href="###">历史</a><span>（1213）</span></li>
            <li><a href="###">哲学</a><span>（1213）</span></li>
            <li><a href="###">体育/运动</a><span>（1213）</span></li>
        </ul>
    </div><!-- 图书商品分类 END -->
    
    <div class="content-right">
        <!-- 排序条件（评分、价格等） -->
    	<div class="row01">
          <p class="px">
            <a href="###"><img src="images/xl.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/pf.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/jg.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/zk.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/cbsj.jpg"  /></a>
         </p>
        </div><!-- 排序条件（评分、价格等） END -->
        <c:forEach items="${list}" var="book">
        <!-- 循环内容 part 1 -->
        <div class="row02">
        	<a href="###"><img src="cover/suanfa.jpg" height="150" width="150" /></a>
        	<h2><a href="BookDetailServlet?id=${book.id }">${book.name}</a></h2>
            <p>
           	 （美）<a href="###">马克·艾伦·维斯</a> 文
            <a href="###">陈越</a>，<a href="###">冯舜玺</a> 译/2009年08月/<a href="page_02.html">机械工业出版社</a>
            </p>
            <p>
                   本书是国外数据结构与算法方面的经典教材,使用卓越的java编程语言作为实现工具,
           讨论数据结构(组织大量数据的方法)和算法分析(对算法运行时间的估计)。
                   随着计算机速度的不断增加和功能的日益强大,人们对有效编程和算法分析的要求也日益增长,
          本书能将算法分析与java程序开发有机结合。
           
            </p>
            <form action="" method="get">
            <p class="p02">
            <span class="red">￥75.90</span> &nbsp;&nbsp;<span class="line-through">￥138.00</span> &nbsp;&nbsp;折扣：55折
            <input type="button" class="buy" />
            </p>
            </form>
        </div>
        </c:forEach>
        
        
        <!-- 分页 -->
        <div class="row04">
        <a href="BookListServlet?currentPage=${currentPage-1 }">上一页</a> 
        <c:forEach begin="1" end="${totalPage}" var="i">
        <c:if test="${currentPage==i }">
        <font color="red">${i }</font>
        </c:if>
        <c:if test="${currentPage!=i }">
        <a href="BookListServlet?currentPage=${i}">${i}</a>
        </c:if>
        </c:forEach>
         <a href="BookListServlet?currentPage=${currentPage+1}">下一页</a>
        &nbsp;&nbsp;共<span>5</span>页 到第<input type="text" class="inputPage" />页
        </div><!-- 分页 END -->
    </div><!-- content-right部分 END -->
  </div><!-- content部分 END -->
 
  
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</body>
</html>
 