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
    <title>商品详情页</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/shop/home.js"></script>
	<link rel="stylesheet" href="css/shop/GoodMessage.css">	
  </head>
  
<body>
<div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li><a href="#">首页</a></li>           
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/user_findUser.action?finduserid=${sessionScope.loginuser.userId}">个人中心</a></li>                       
            <li><a href="#">退出登录</a></li>
            <li>欢迎您:${sessionScope.loginuser.userName}</li> 
        </ul>
  </div>
</div>
<div class="mid">
  <div class="cui_hd">
    <div class="ctriplogo"> <a title="" href="#"> </a> </div>
    <div class="cui_search">
      <input type="text" placeholder="搜索" id="_allSearchKeyword" />
      <button type="button" id="search_button_global"></button>   
    </div>
    <div class="nav-shop"> <a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
    <img src="image/shop/shoplogo.png" /></a></div>
  </div>
  <div class="sell-contanier">
     <div id="sell-center">
          <div id="wantbuy"><a href="#"><button type="button" id="want-buy">我要买</button></a></div>
          <div id="wantsell"><a href="${pageContext.request.contextPath}/shop_toAddGood.action"><button type="button" id="want-sell">我要卖</button></a></div>
     </div>
  </div>      
</div>
<div class="bottom" >
    <div class="bottom-userMessage">
        <table width="879" id="user-table" border="0">
            <tr>
              <td width="120">
              	<div id="user-photo"><a href="${pageContext.request.contextPath}/shop_findUserGood.action?findByuserid=${users.userId}&goodState=yishangjia">
              	<img src="${users.userImage}"  width="102" height="104"></a></div>
              </td>
              <td>
                <div id="user-message">
                  <span id="user-name">${users.userName}</span>
                  <span id="user-dec">信用较好</span>
                </div>
                <div id="user-school">${users.userSchool}</div>
            </td>      
            </tr>          
          </table>
    </div>
</div>
</body>
</html>
