<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>当当网-名社新书大PK</title>
<link href="css/page_04.css" rel="stylesheet" type="text/css" media="all" />
<script>
function addUser()
//验证addUser方法是否被调动，没问题以后注释掉
{alert("注册成功,跳转到登录页");
//js的简单应用要复习一下，www.w3c.com
//w3c jquery的内容都可以看
	//提交form，form没有submit按钮，需要js提交
	//获得表单对象然后调用提交方法，js也是面向对象的语言
	//给表单加一个id属性id="user"
	document.getElementById("user").submit();
}
</script>
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
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 -->
  
  <!-- content 部分 -->
  <div id="content">
    <!-- 注册信息 -->
  	<form action="AddUserServlet" id="user">
  	<p><span>登录名：</span><input type="text" name="name" class="textInput" /></p>
    
    <p><span>Email地址：</span><input type="text" name="email" class="textInput" /></p>
    <p><span>登录密码：</span><input type="text"  name="password" class="textInput" /></p>
    <p><span>确认密码：</span><input type="text"  class="textInput" /></p>
    <p><span>&nbsp;&nbsp;&nbsp;&nbsp;验证码：</span><input type="text" class="textInput" /></p>
    <p><img src="images/Page_04_yzm.png" alt="" /><span class="grey">看不清？</span><a href="###">换张图</a></p>
    <p><input type="button" value="" class="btn" onclick="addUser()"/></p>
    <p><input name="" type="checkbox" value="" /> 我已阅读并同意《当当网交易条款》和《当当网社区条款》</p>
    </form>
  </div>
  
</div>
</body>
</html>
    