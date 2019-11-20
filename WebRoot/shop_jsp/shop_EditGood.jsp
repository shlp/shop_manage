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
    
    <title>我的店铺--商品编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" href="css/shop/EditGood.css">
	<script src="js/shop/EditGood.js"></script>
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
     <div class="nav-shop"><a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
    <img src="image/shop/shoplogo.png" />
    </a> </div>
  </div>
  <div class="sell-contanier">
     <div id="sell-center">
           <div id="wantbuy"><a href="#"><button type="button" id="want-buy">我要买</button></a></div>
           <div id="wantsell"><a href="#"><button type="button" id="want-sell">我要卖</button></a></div>
     </div>
  </div>   
</div>
<div class="bottom">
 <form id="publish"  action="shop_updateGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=daishenhe"method="post" enctype="multipart/form-data">
	<div class="bottom-center">
	         <div class="div_black" class="div_black"></div>
	         <div class="div_black1" class="div_black1"></div>              		    
				<div class="div_iterm" >
				   <h1 class="confirm">还未上传文件</h1>
				   <h1 class="confirmup">请选择文件上传!</h1>				        	
				   <div class="div_sub"><h1  class="close_btn">确认</h1></div>        
			    </div>  
			    <div class="div_iterm1" >
				   <h1 class="confirm1">输入不规范</h1>
				   <h1 class="confirmup1">请输入中文,英文,数字,可使用逗号!</h1>				        	
				   <div class="div_sub1"><h1  class="close_btn1">确认</h1></div>        
			    </div>     	 
        	<dl id="pubContanier"> <input type="hidden"   name="findgoodid"  id="good-id" value="${requestScope.good.goodId}"/>
            	<dd class="goodOne"><img id="good-picture"src="${requestScope.good.goodPricture}" width="126" height="157"><input id="file" type="file" name="upload"/></dd>
                <hr class="good-hr"></hr>
                <dd class="good">商品名称&nbsp;<input class="good-name" name="goodName" type="text" value="${requestScope.good.goodName}" placeholder="最多14个字" id="good-name"><span class="span_name">请输入数字、英文或者中文</span></dd>
                <hr class="good-hr"></hr>
                <dd class="goodDp"><textarea id="good-description" name="goodDescription" class="textarea" row="3"maxlength="30" value="${requestScope.good.goodDescription}" onfocus="document.getElementById('note').style.display='none'" onblur="if(value=='')document.getElementById('note').style.display='block'"></textarea>
        <div id="note" class="note">
            <font color="#dedddd">${requestScope.good.goodDescription}</font>
        </div></dd>
        		<hr class="good-hrt"></hr>
                <dd class="goodTwo">商品价格&nbsp;<input class="good-price" name="goodPrice" type="text" value="${requestScope.good.goodPrice}" placeholder="输入数字" id="good-price"><span class="span_price">请输入合格数字(不能以0开头后面加正整数，如果是浮点数，整数部分不能为两个0)</span></dd></hr>
                <hr class="good-hr">
               <%--  <dd class="goodTwo">商品库存&nbsp;<input class="good-ull" name="goodNum" type="text" value="${requestScope.good.goodNum}" placeholder="输入数字"id="good-count"></dd>
                <hr class="good-hr"></hr> --%>
                <dd class="goodTwo">商品分类&nbsp;
                	<select name="typeId" id="good-type">
                		<s:iterator  id="typeItem" value="goodTypeList" status="st">
                			<option value="<s:property value="typeId"/>">
                				${typeItem.typeName}
                			</option>              			
                		</s:iterator>
                </select></dd>
                           
        	</dl>  
    </div>
    <div id="button-sub"> 
   	  <!--   <div class="div_black" class="div_black"></div>
        <div class="div_iterm" class="div_iterm">
            <h1 class="confirm">确认重新发布吗?</h1>
            <div class="div_sub"><button  class="submit_btn">确认</button></div>
            <div class="div_cancle"><button class="close_btn">取消</button></div>         
        </div> -->

   			 <input type="submit" class="goodSub" id="goodSub" value="再次发布"/> 
   			<!-- <button type="button" class="goodSub" id="goodCancle">再次发布</button> -->
            <a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
            	<button type="button" id="goodCancle">取消</button></a>
    </div>
</form>
 
</div>

  
  
  
  </body>
</html>
