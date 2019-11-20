<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
    <script type="text/javascript" src="js/admin/admin_login/admin_login.js"></script>
    <link rel="stylesheet" href="css/shop/userlogin.css" >
  </head>
  
  <body>
<div class="adminLogin">

 <s:form action="user_login" method="post"> 
<div id="adminLogin_top" class="adminLogin_top" >
<img src="image/shop/userone.png" width="154" height="100" />
</div>

<div id="adminLogin_center"   class="adminLogin_center">
<h3>用户名：<input name="userName" type="text" value="" /></h3>
<br /><br />
<h3>密码：<input name="userPassword" type="password" value="" /></h3>
</div>

<div id="adminLogin_bottom" class="adminLogin_bottom" >
 <input type="submit" value="" class="sub" style="background:url(image/shop/admin_three.png)"/>
  </div>
  </s:form> 
</div>
</body>
</html>
