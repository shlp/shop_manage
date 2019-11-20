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
    
    <title>我的店铺--失效商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" href="css/shop/InvaildGood.css">
	
  </head>
  
  <body>
  <div class="top">
    <div id="site-nav">
        <ul class="sn-quick-menu">
            <li><a href="shop_jsp/shop_HomePagelogin.jsp">首页</a></li>
            <li><a href="#">消息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/user_findUser.action?finduserid=${sessionScope.loginuser.userId}">个人中心</a></li>
            <li><a href="#">欢迎您:${sessionScope.loginuser.userName}</a></li> 
            <li><a href="shop_jsp/shop_HomePage.jsp">退出登录</a></li>
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
    <div class="nav-shop"><a href="${pageContext.request.contextPath}/shop_findUpAllGood.action?findByuserid=${sessionScope.loginuser.userId}&goodState=yishangjia">
    <img src="image/shop/shoplogo.png" /></a> </div>
  </div>
</div>
<div class="bottom">
	<div class="bottom-shop">
    	<div id="userMessage">
        	<table width="879" id="user-table" height="140" border="0">
            	<tr>
                	<td width="360"><div id="user-photo"><img src="${sessionScope.loginuser.userImage}" width="100" height="100"></div></td>
                	<td width="509" ><div id="down-good"><a href="#">失效商品</a></div></td>
                </tr>
                <tr><td ><p id="user-name">${sessionScope.loginuser.userName}</p></td></tr>
            </table>
        </div>
        <div id="gooddown">
          <s:iterator id="goodItem" value="#request.goodList" status="st">
            <s:if test="#st.getIndex()==0">   
           	<!-- <div class="gooddown-item1"></div>    -->     	
           <div class="gooddown-item1">
                <div class="gooddownitem">
                   	 <span class="downself">无库存</span>
                </div>
               <hr class="goodhr"></hr>
             
               <span class="downTwo">
                  <dl >
                    <dt class="down-photo"><img src="<s:property value="goodPricture"/>" width="115" height="118"></dt>
                    <dd class="down-name"><s:property value="goodName"/></dd>
                    <dd class="down-price" >￥<s:property value="goodPrice"/></dd>
                  </dl>
               </span>
             
                   <span class="hr"><hr class="goodhr1"></hr></span>
               <div class="gooddown-sub">
                 <a href="${pageContext.request.contextPath}/shop_deleteGood.action?findBygoodid=<s:property value="goodId"/>"> <button type="button" class="delete">删除</button></a>   
               </div>                                          
            </div>
           </s:if>  
            <s:if test="#st.getIndex()!=0">      
            <div class="gooddown-item">
                <div class="gooddownitem">
                   	 <span class="downself">无库存</span>
                   
                </div>
               <hr class="goodhr"></hr>
             
               <div class="downTwo">
                  <dl >
                    <dt class="down-photo"><img src="<s:property value="goodPricture"/>" width="115" height="118"></dt>
                    <dd class="down-name"><s:property value="goodName"/></dd>
                    <dd class="down-price" >￥<s:property value="goodPrice"/></dd>
                  </dl>
               </div>
                            
               <hr class="goodhr1"></hr>
               <div class="gooddown-sub">
       
               <a href="${pageContext.request.contextPath}/shop_deleteGood.action?findBygoodid=<s:property value="goodId"/>"><button type="button" class="delete">删除</button> </a>  
               </div>                              
            </div>
           </s:if>
           </s:iterator> 
          	<!-- 遍历结束 -->
            <!-- 分页 -->
	       <table id="table-page">
	     	<tr>
	     		<td width="130"></td>
	     		<td width="100">
	     			<s:if test="pageBean.currpage>1">
	     				<a href='/shop_manage/shop_findUpAllGood.action?pageBean.currpage=1
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>首页</a>&nbsp;&nbsp;
	     				<a href='${pageContext.request.contextPath}/shop_findUpAllGood.action?pageBean.currpage=${pageBean.currpage-1}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>上一页</a>
	     			</s:if>
	     		</td>
	     		<td width="100">
	     			<s:if test="pageBean.currpage<pageBean.totalpage">
	     				<a href='/shop_manage/shop_findUpAllGood.action?pageBean.currpage=${pageBean.currpage+1}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>下一页</a>&nbsp;&nbsp;
	     				<a href='/shop_manage/shop_findUpAllGood.action?pageBean.currpage=${pageBean.totalpage}
	     				&findByuserid=${requestScope.findByuserid}&goodState=${requestScope.goodState}'>尾页</a>
	     			</s:if>
	     		</td>
	     		<td>共${pageBean.totalcount}记录，共${pageBean.currpage}/${pageBean.totalpage}页&nbsp;&nbsp;</td>    	
	     	</tr> 
	     </table>
     <!-- 分页结束 -->
        </div>
     </div>
</div>
  
  
  </body>
</html>
