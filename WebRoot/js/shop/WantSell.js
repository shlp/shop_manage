//// JavaScript Document
$(document).ready(function(){  

	$('#file').on('change',function(){
    	var filePath = $(this).val(),         //获取到input的value，里面是文件的路径
    	    fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
    	// 检查是否是图片
    	if( !fileFormat.match(/.png|.jpg|.jpeg/) ) {
    		error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
        	return;  
        }    	
    	src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
    	
    	$('#good-picture').attr('src',src);
        //$('#good-picture').attr('src',filePath);
        
        //$('#loding').show();
   });
});

// 		
//    $('.goodSub').bind('click',function(){
//        $('.div_black').css('display','block');
//        $('.div_iterm').css('display','block');
//
//       
//    });
//    $('.submit_btn').live('click',function(){
//        $('.div_black').css('display','none');
//        $('.div_iterm').css('display','none');
//        alert($("#good-id").val());
//        //下面可以向服务器请求
////    	$.getJSON("shop_updateGood",{
////    		
////    		"findBygoodid":$("#good-id").val(),		    	
////		    "goodName" : $("#good-name").val(),	
////		    "goodDescription":$("#good-description").val(),	
////		    "goodPrice":$("#good-price").val(),
////		    "goodType":$("#good-type").val(),
////		    "goodState":$("#good-state").val()
////    	});
//        
////      $.ajax({
////	    type: "POST",
////	    url: "shop_updateGoodState.action", //orderModifyStatus
////	    data: {"findBygoodid":$("#good-id").val(),"goodState":$("#good-state").val()},
////	$.getJSON("shop_updateGoodState.action",{
////		    "findByuserid":$("#user-id").val(),
////		   "findBygoodid":$("#good-id").val(),		    	
//////	    "goodName" : $("#good-name").val(),	
//////	    "goodDescription":$("#good-description").val(),	
//////	    "goodPrice":$("#good-price").val(),
//////	    "goodType":$("#good-type").val(),
////	    "goodState":$("#good-state").val()
//////	});
// //  window.location.href="shop_updateGoodState.action?findBygoodid="+findBygoodid+"&goodState="+goodState;
//  // window.open('shop_updateGoodState');
//
////});
//
//    });
// 


