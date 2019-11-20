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
    <title>咸菜首页</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/shop/HomePageByType.js"></script>
	<link rel="stylesheet" href="css/shop/HomePageByType.css">	
  </head>
  
<body>
<div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li><a href="${pageContext.request.contextPath}/shop_toShowHome.action">首页</a></li> 
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/user_findUser.action?finduserid=${sessionScope.loginuser.userId}">个人中心</a></li>                       
            <li><a href="shop_jsp/shop_HomePage.jsp">退出登录</a></li>
            <li>欢迎您:${sessionScope.loginuser.userName}</li> 
        </ul>
  </div>
</div>
<form method="post" action="shop_findGoodBytypeId.action?typeId=${goodtype.typeId}">
<div class="mid">
  <div class="cui_hd">
    <div class="ctriplogo"> <a title="" href="#"> </a> </div>
    <div class="cui_search">
      <input type="text" placeholder="搜索" name="goodName" id="_allSearchKeyword" />
      <button type="submit" id="search_button_global"></button>
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
    <div class="left-type">
      <h1 class="list-one">全部分类</h1>
    </div>
    <div class="list-message">
      <ul class="type-list">
        <s:iterator value="TypeList" >      
          <li>
          	<a href="${pageContext.request.contextPath}/shop_findGoodBytypeId.action?typeId=<s:property value="typeId"/>">
          	<s:property value="typeName"/></a>
          </li>   			
   	   </s:iterator>  
      </ul>
   </div>
   <div class="right-image" id="screen">
     <ul id="ul">
      <li><img src="image/home/09.png" width="379" height="400"/></li>
      <li><img src="image/home/05.png" width="189" height="400"/></li>
      <li><img src="image/home/06.png" width="191" height="400"/></li>
      <li><img src="image/home/07.png" width="190" height="400"/></li>
      <li><img src="image/home/08.png" width="230" height="400"/></li>
     </ul>
  </div>
</div>
</form> 
<div class="foot">
  <hr class="foot-hr"></hr>
  <div class="menu"><button class="menu-head">咸菜集市</button></div>
  <div class="good-menu">
    <div class="good-tosell">  
        <div class="message">${goodMessage}</div>    
     	<table id="goodTable" width="1180"  >
       <s:iterator  id="goodSellItem" value="goodToSellList" status="st">
         <s:if test="#st.getIndex()%4==0">
        <tr>
         </s:if>
          <td width="220" class="goods">
            <div class="good">                   
              <div class="good-photo">
              <a href="${pageContext.request.contextPath}/shop_tofindGoodByGoodId.action?findBygoodid=${goodSellItem.goodId}">
                <img src="${goodSellItem.goodPricture}" width="180" height="190">
              </a>
              </div>
              <div class="good-name">${goodSellItem.goodName}</div>
              <div class="good-item">
                <div class="good-price">${goodSellItem.goodPrice}</div>
              </div>
            </div>
          </td>
          <s:if test="#st.getIndex()%4==3">
        </tr>
       </s:if>
       </s:iterator>
      </table>      
    </div>  
  </div>
  <!-- 分页 -->
   <table id="table-page">
    <tr>
      <td id="onepage">
        <s:if test="pageBean.currpage>1">
          <a href='/shop_manage/shop_findGoodBytypeId.action?pageBean.currpage=1
          &typeId=${goodtype.typeId}&goodState=${requestScope.goodState}'>首页</a>&nbsp;&nbsp;
          <a href='${pageContext.request.contextPath}/shop_findGoodBytypeId.action?pageBean.currpage=${pageBean.currpage-1}
          &typeId=${goodtype.typeId}&goodState=${requestScope.goodState}'>上一页</a>&nbsp;&nbsp;
        </s:if>       
        <s:if test="pageBean.currpage<pageBean.totalpage">
          <a href='/shop_manage/shop_findGoodBytypeId.action?pageBean.currpage=${pageBean.currpage+1}
          &typeId=${goodtype.typeId}&goodState=${requestScope.goodState}'>下一页</a>&nbsp;&nbsp;
          <a href='${pageContext.request.contextPath}/shop_findGoodBytypeId.action?pageBean.currpage=${pageBean.totalpage}
          &typeId=${goodtype.typeId}&goodState=${requestScope.goodState}'>尾页</a>
        </s:if>
      </td>
      <tr>
        <td id="allpage">共${pageBean.totalcount}记录，共${pageBean.currpage}/${pageBean.totalpage}页&nbsp;&nbsp;</td> 
      </tr>   	
    </tr> 
  </table>

<!-- 分页结束 -->
</div>  

</body>
</html>
