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
    
    <title>我的店铺--浏览他人店铺</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" href="css/shop/HimShop.css">
	
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
        </ul>
  </div>
</div>
<div class="mid">
  <div class="cui_hd">
    <div class="ctriplogo"></div>
    <div class="ctripxiancai">咸菜</div>
    <div class="cui_search">
    <form method="post" action="shop_findUserGood.action?findByuserid=${user.userId}&goodState=yishangjia">
      <input type="text" placeholder="搜索" name="goodName" id="_allSearchKeyword" />
      <button type="submit" id="search_button_global"></button>
    </form>
    </div>
    <div class="nav-shop"><a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
    <img src="image/shop/shoplogo.png" />
    </a> </div>
  </div>
</div>
<div class="bottom">
	<div class="bottom-shop">
    	<div id="userMessage">
        	<table width="879" id="user-table" border="0">
            	<tr>
                	<td width="449"><div id="user-photo"><img src="${user.userImage}" width="100" height="100"></div></td>
                	<td width=""><a href="#"><button type="button" id="phone">电话联系</button></a></td>
                    <td width=""><a href="#"><button type="button" id="chatself">私聊</button></a></td>
                    <td width=""><a href="#"><button type="button" id="concerned">关注他</button></a></td>
                </tr>
                <tr><td ><p id="user-name">${user.userName}<s:property value="userName"/></p></td></tr>
            </table>
      </div>
        <div id="good-table">
        	<table id="goodTable" width="880"  >
        	 <s:iterator  id="goodItem" value="goodList" status="st">
        	 	<s:if test="#st.getIndex()%4==0">
            	<tr>
            	</s:if>
                    <td width="220" class="goods">
                     <div class="good">                      
                        	<div class="good-photo">
                        	<img src="${goodItem.goodPricture}" width="180" height="190">
                        	  <%-- <img src="${goodItem.goodImage}" width="180" height="190"> --%>
                        	</div>
                            <div class="good-name">
                            	<s:property value="goodName"/>&nbsp;&nbsp;
                                <s:property value="goodDescription"/>
                            </div>
                            <div class="good-item">
                                    <div class="good-price">￥<s:property value="goodPrice"/></div>
                      		 </div>
                     </div>
                    </td>  
                <s:if test="#st.getIndex()%4==3">
            	</tr>
            	</s:if>               
             </s:iterator>          
            </table>
                 
   			<!-- 遍历结束 -->
            <!-- 分页 -->
	       <table id="table-page">
	     	<tr>
	     		<td id="onepage" width="100">
	     			<s:if test="pageBean.currpage>1">
	     				<a href='/shop_manage/shop_findUserGood.action?pageBean.currpage=1
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>首页</a>&nbsp;&nbsp;
	     				<a href='${pageContext.request.contextPath}/shop_findUserGood.action?pageBean.currpage=${pageBean.currpage-1}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>上一页</a>
	     			</s:if>
	     			<s:if test="pageBean.currpage<pageBean.totalpage">
	     				<a href='/shop_manage/shop_findUserGood.action?pageBean.currpage=${pageBean.currpage+1}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>下一页</a>&nbsp;&nbsp;
	     				<a href='/shop_manage/shop_findUserGood.action?pageBean.currpage=${pageBean.totalpage}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>尾页</a>
	     			</s:if>
	     		</td>
	     	</tr> 
	     	<tr><td id="allpage">共${pageBean.totalcount}记录，共${pageBean.currpage}/${pageBean.totalpage}页&nbsp;&nbsp;</td>    	</tr>
	     </table>
     <!-- 分页结束 -->
        </div>
    </div>
</div>

  
  
  </body>
</html>
