// JavaScript Document
$(document).ready(function(){  
 		
//   $(".down-cause").click(function (){
//		var $context=$("<div>主动下架"+"</div"+"你已下架了该宝贝，可以选择重新发布");
//
//   });
   
   $('.upGood').bind('click',function(){
       $('.div_black').css('display','block');
       $('.div_iterm').css('display','block');

      
   });
   $('.submit_btn').live('click',function(){
       $('.div_black').css('display','none');
       $('.div_iterm').css('display','none');
       alert($("#good-id").val());
       alert($("#good-state").val());
       alert($("#user-id").val());
       //下面可以向服务器请求
//       $.ajax({
//   	    type: "POST",
//   	    url: "shop_updateGoodState.action", //orderModifyStatus
//   	    data: {"findBygoodid":$("#good-id").val(),"goodState":$("#good-state").val()},
   	    var findBygoodid=$("#good-id").val();
   	    var goodState=$("#good-state").val();
//   	$.getJSON("shop_updateGoodState.action",{
//   		    "findByuserid":$("#user-id").val(),
//   		   "findBygoodid":$("#good-id").val(),		    	
////		    "goodName" : $("#good-name").val(),	
////		    "goodDescription":$("#good-description").val(),	
////		    "goodPrice":$("#good-price").val(),
////		    "goodType":$("#good-type").val(),
//		    "goodState":$("#good-state").val()
// 	});
       window.location.href="shop_updateGoodState.action?findBygoodid="+findBygoodid+"&goodState="+goodState;
	  // window.open('shop_updateGoodState');

   });
 });