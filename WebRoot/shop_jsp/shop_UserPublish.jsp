<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/shop/UserPublish.css">
    <script src="js/jquery-1.6.2.js"></script>
  </head>
  
   <body>
  <div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li><a href="${pageContext.request.contextPath}/shop_toShowHome.action">首页</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li>个人中心</li>
            <li><a href="shop_jsp/shop_HomePage.jsp">退出登录</a></li>
            <li>欢迎您:${sessionScope.loginuser.userName}</li> 
        </ul>
  </div>
</div>
<div class="mid">
  <div class="cui_hd">
    <div class="ctriplogo"></div>
    <div class="ctripxiancai">咸菜</div>
    <div class="cui_search">
      <input type="text" placeholder="搜索" id="_allSearchKeyword" />
      <button type="button" id="search_button_global"></button>   
    </div>
    <div class="nav-shop"> <a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
    <img src="image/shop/shoplogo.png" /></a></div>
  </div>
</div>


<div class="shenhe_bottom">
<div class="shenhe_left">
<div class="head"><img src="${sessionScope.loginuser.userImage}" width="80" height="80">
   </div>
   <div class="name"><h3>${sessionScope.loginuser.userName}</h3></div><%-- {loginuser.userName} --%>
<div class="chuli">
    <ul class="left_menu">
    		<li><a href="${pageContext.request.contextPath}/shop_jsp/shop_alteruser.jsp">编辑</a></li>
            <li><a href="">消息</a></li>
            <li><a href="">收藏</a></li>
            <li><a href="">我买入的</a></li>
            <li><a href="">我卖出的</a></li>
            <li><a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">我发布的</a></li>
           <%--  <li><a href="<s:url action=""/>">我发布的</a></li> --%>
            <li><a href="">我的足迹</a></li>
        </ul>
   </div>
</div>



<div class="shenhe_right">
  <img src="image/shop/image17.png" width="auto" height="550"> </div>
</div>


    
   
  </body>
</html>
