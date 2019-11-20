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
	<script src="js/shop/home.js"></script>
	<link rel="stylesheet" href="css/shop/HomePagelogin.css">	
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
<form method="post" action="shop_findGoodBytypeId.action">
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
    <ul class="type-list">
       <li class="list-one">全部分类</li>
       <s:iterator value="TypeList" >      
          <li>
          	<a href="${pageContext.request.contextPath}/shop_findGoodBytypeId.action?typeId=<s:property value="typeId"/>">
          	<s:property value="typeName"/></a>
          </li>   			
   	   </s:iterator>  	  
    </ul>      
  </div>
</form>
  <div class="right-image" id="screen">
     <ul id="ul">
      <li><img src="image/home/0.jpg" width="1020" height="345"/></li>
      <li><img src="image/home/1.jpg" width="1020" height="345"/></li>
      <li><img src="image/home/2.jpg" width="1020" height="345"/></li>
      <li><img src="image/home/3.jpg" width="1020" height="345"/></li>
     </ul>
    <ol></ol>
    <div id="arr">
      <span id="left"> < </span>
      <span id="right"> > </span>
    </div>
  </div>
</div>
<div class="foot">
  <hr class="foot-hr"></hr>
  <div class="menu"><button class="menu-head">咸菜集市</button></div>
  <div class="foot-menu">
    <div class="menu-tosell">    
      <span class="menu-sell">卖场</span>
    </div>
    <div class="menu-tobuy">
        <span class="menu-buy">求购</span>
    </div>
  </div>
  <div class="good-menu">
    <div class="good-tosell">      
      <table id="sellTable" width="525">
  
       <s:iterator  id="goodSellItem" value="goodToSellList" status="st">
         <s:if test="#st.getIndex()%2==0">
        <tr>
         </s:if>
          <td width="240" class="goods">
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
       <s:if test="#st.getIndex()%2==1">
        </tr>
       </s:if>
       </s:iterator>
      </table>      
    </div>  
    <div class="good-tobuy">
       <table id="buyTable" width="525">
            <tr>
              <td width="240" class="goods">
                <div class="good">                   
                  <div class="good-photo">
                    <img src="image/shop/eg.png" width="180" height="190">
                  </div>
                  <div class="good-name">顺丰正品华为手机1+[可售499]xl</div>
                  <div class="good-item">
                    <div class="good-price">￥1250</div>
                  </div>
                </div>
              </td>
              <td width="220" class="goods">
                <div class="good">
                  <div class="good-photo">
                    <img src="image/shop/eg.png" width="180" height="190">
                  </div>
                  <div class="good-name">顺丰正品华为手机1+[可售499]xl</div>
                  <div class="good-item">
                    <div class="good-price">￥1250</div>
                    </div>
                  </div>
              </td>
            </tr>
            <tr>
                <td width="240" class="goods">
                  <div class="good">                   
                    <div class="good-photo">
                      <img src="image/shop/eg1.png" width="180" height="190">
                    </div>
                    <div class="good-name">顺丰正品华为手机1+[可售499]xl</div>
                    <div class="good-item">
                      <div class="good-price">￥1250</div>
                    </div>
                  </div>
                </td>
                <td width="220" class="goods">
                  <div class="good">
                    <div class="good-photo">
                      <img src="image/shop/eg1.png" width="180" height="190">
                    </div>
                    <div class="good-name">顺丰正品华为手机1+[可售499]xl</div>
                    <div class="good-item">
                      <div class="good-price">￥1250</div>
                      </div>
                    </div>
                </td>
              </tr>
        </table>
       <%--  <table id="buyTable" width="525">
        <s:iterator  id="goodbuyItem" value="goodtobuyList" status="st">
            <s:if test="#st.getIndex()%2==0">
            <tr>
            </s:if>
              <td width="240" class="goods">
                <div class="good">                   
                  <div class="good-photo">
                   <a href="${pageContext.request.contextPath}/shop_tofindGoodByGoodId.action?findBygoodid=${goodbuyItem.goodId}">
                    <img src="${goodbuyItem.goodPricture}" width="180" height="190">
                   </a>
                  </div>
                  <div class="good-name">${goodbuyItem.goodName}</div>
                  <div class="good-item">
                    <div class="good-price">${goodbuyItem.goodPrice}</div>
                  </div>
                </div>
              </td>
          <s:if test="#st.getIndex()%2==1">
        	</tr>
       	  </s:if>
             </s:iterator>
        </table>      --%>
    </div>
  </div>
  <!-- 分页 -->
   <table id="table-page">
    <tr>
      <td id="onepage">
        <s:if test="pageBean.currpage>1">
          <a href='/shop_manage/shop_toShowHome.action?pageBean.currpage=1
          &goodState=${requestScope.goodState}'>首页</a>&nbsp;&nbsp;
          <a href='${pageContext.request.contextPath}/shop_toShowHome.action?pageBean.currpage=${pageBean.currpage-1}
          &goodState=${requestScope.goodState}'>上一页</a>&nbsp;&nbsp;
        </s:if>       
        <s:if test="pageBean.currpage<pageBean.totalpage">
          <a href='/shop_manage/shop_toShowHome.action?pageBean.currpage=${pageBean.currpage+1}
          &goodState=${requestScope.goodState}'>下一页</a>&nbsp;&nbsp;
          <a href='${pageContext.request.contextPath}/shop_toShowHome.action?pageBean.currpage=${pageBean.totalpage}
          &goodState=${requestScope.goodState}'>尾页</a>
        </s:if>
      </td>
      <tr>
        <td id="allpage">共${pageBean.totalcount}记录，共${pageBean.currpage}/${pageBean.totalpage}页&nbsp;&nbsp;</td> 
      </tr>   	

  </table>

<!-- 分页结束 -->
</div>  

</body>
</html>
