<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的店铺--发布成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" href="css/shop/SubSuccess.css">
	
  </head>
  
  <body>
<div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li>  <a href="shop_jsp/shop_HomePagelogin.jsp">首页</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/user_findUser.action?finduserid=<s:property value="#session.loginuser.userId"/>">个人中心</a></li>
            <li><a href="#">退出登录</a></li>
        </ul>
  </div>
</div>
<div class="mid">
  <span id="photo"><img src="image/shop/xlogo.png" width="138" height="138"></span>
</div>   
<div class="mid-center">
亲，你已发布成功了！！
</div>
<div class="bottom">
    <button type="button" id="want-buy" onclick="window.location.href('/shop_manage/shop_jsp/shop_HomePagelogin.jsp')">返回首页</button>
    <a href="#"><button type="button" id="want-sell">返回商品详情页</button></a>
</div>
 



  
  
  </body>
</html>
