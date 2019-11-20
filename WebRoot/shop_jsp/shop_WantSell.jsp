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
    <title>我的店铺--我要卖</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" href="css/shop/WantSell.css">
	<script src="js/shop/WantSell.js"></script>
  </head> 
<body>
 <div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li><a href="shop_jsp/shop_HomePagelogin.jsp">首页</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/user_findUser.action?finduserid=<s:property value="#session.loginuser.userId"/>">个人中心</a></li>
            <li><a href="#">欢迎您:<s:property value="#session.loginuser.userName"/></a></li> 
            <li><a href="shop_jsp/shop_HomePage.jsp">退出登录</a></li>
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
    <div class="nav-shop"> <a title="" href="#"> </a> </div>
  </div>
  <div class="sell-contanier">
     <div id="sell-center">
           <div id="wantbuy"><a href="#"><button type="button" id="want-buy">我要买</button></a></div>
           <div id="wantsell"><a href="#"><button type="button" id="want-sell">我要卖</button></a></div>
     </div>
  </div>   
</div>
<div class="bottom">
<form id="publish"  action="shop_publish.action?findByuserid=${sessionScope.loginuser.userId}"method="post" enctype="multipart/form-data">
	<div class="bottom-center">       	
        	<dl id="pubContanier">
            	<dd class="goodOne"><%-- <s:hidden name="goodId"></s:hidden><s:hidden name="userId" value="#session.loginuser.userId"></s:hidden> --%>
            						<img id="good-picture"src="image/shop/addPhoto.png" width="126" height="107"><input type="file" name="upload" id="file"></dd>
                <hr class="good-hr"></hr>
                <dd class="good">商品名称&nbsp;<input class="good-ull" name="goodName" type="text" placeholder="最多14个字" id="good-name"></dd>
                <hr class="good-hr"></hr>
                <dd class="goodDp"><textarea name="goodDescription" class="textarea" row="3"maxlength="30" onfocus="document.getElementById('note').style.display='none'" onblur="if(value=='')document.getElementById('note').style.display='block'"></textarea>
        <div id="note" class="note">
            <font color="#dedddd">描述一下你的宝贝...</font>
        </div></dd>
        		<hr class="good-hrt"></hr>
                <dd class="goodTwo">商品价格&nbsp;<input class="good-ull" name="goodPrice" type="text" placeholder="输入数字" id="good-price"></dd>
                <hr class="good-hr"></hr>
                <dd class="goodTwo">商品库存&nbsp;<input class="good-ull" name="goodNum" type="text" placeholder="输入数字"id="good-count"></dd>
                <hr class="good-hr"></hr>
                <dd class="goodTwo">商品分类&nbsp;
                	<select name="typeId" id="good-type">
                		<s:iterator  id="typeItem" value="goodTypeList" status="st">
                			<option value="<s:property value="typeId"/>">
                				${typeItem.typeName}
                			</option>              			
                		</s:iterator>
                	</select>
                </dd>
                           
        	</dl>  
    </div>
    <div id="button-sub">
   			<button  id="goodSub" >发布</button>
    </div>
</form>
 
</div>

  
  
  
  </body>
</html>
