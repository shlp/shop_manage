//// JavaScript Document
$(document).ready(function(){  
// 		
   $(".down-cause").click(function (){
		  $('.div_black').css('display','block');
	      $('.div_iterm').css('display','block');
	      
   });

 $('.close_btn').bind('click',function(){
 $('.div_black').css('display','none');
 $('.div_iterm').css('display','none');


});
$('.submit_btn').live('click',function(){
 $('.div_black').css('display','none');
 $('.div_iterm').css('display','none');

});
//   $('.upGood').bind('click',function(){
//       $('.div_black').css('display','block');
//       $('.div_iterm').css('display','block');
//       $('.confirmup').css('display','block');
//       
//
//      
//   });
//   $('.close_btn').bind('click',function(){
//       $('.div_black').css('display','none');
//       $('.div_iterm').css('display','none');
//       $('.confirmup').css('display','none');
//       alert($(".good-id").val());
//       alert($(".good-state").val());
//       alert($(this).parent().parent().parent().parent().html());
//       //下面可以向服务器请求
//
//   });
//   $('.submit_btn').live('click',function(){
//       $('.div_black').css('display','none');
//       $('.div_iterm').css('display','none');
//       $('.confirmup').css('display','none');
//      
//       //向服务器请求
//   	    var findBygoodid=$(".good-id").val();
//   	    var goodState=$(".good-state").val();
//       window.location.href="shop_updateGoodState.action?findBygoodid="+findBygoodid+"&goodState="+goodState;
//
//   });
//   $('.delete').bind('click',function(){
//       $('.div_black').css('display','block');
//       $('.div_iterm1').css('display','block');
//       $('.confirmdelete').css('display','block');            
//   });
//   $('.close_btn1').bind('click',function(){
//       $('.div_black').css('display','none');
//       $('.div_iterm1').css('display','none');
//       $('.confirmdelete').css('display','none');
//       alert($(".good-id").val());
//       //下面可以向服务器请求
//     
//   });
//   
//   $('.delete-btn').live('click',function(){
//       $('.div_black').css('display','none');
//       $('.div_iterm1').css('display','none');
//       $('.confirmdelete').css('display','none');
//       alert($(".good-id").val());
//       //向服务器请求
//   	    var findBygoodid=$(".good-id").val();
//       window.location.href="shop_deleteGood.action?findBygoodid="+findBygoodid;
//
//   }); 


});