//// JavaScript Document
$(document).ready(function(){  

//	$('#file').blur(function(){
//		var value=$(this).val();
//		if(value.equals("")){
//			 alert("111");
//			 $('.div_black').css('display','block');
//		     $('.div_iterm').css('display','block');
//		}
//		else{
//			$('.div_black').css('display','hidden');
//		    $('.div_iterm').css('display','hidden');
//		}
//	});
	
//	if(value.equals("")){
//		 alert("111");
//		 $('.div_black').css('display','block');
//	     $('.div_iterm').css('display','block');
//	}
//	else{
//		$('.div_black').css('display','hidden');
//	    $('.div_iterm').css('display','hidden');
//	}
	
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
	
 $('.good-name').focus(function(){
	var value=$('#file').val();
	if(value==""){
		 
		 $('.div_black').css('visibility','visible');
	     $('.div_iterm').css('visibility','visible');
	}
	else{
		$('.div_black').css('visibility','hidden');
	    $('.div_iterm').css('visibility','hidden');
	}
 });	
	
	$('.good-name').blur(function(){
		var value=$(this).val();
		var reg=new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+$");		
		if(!reg.test(value)){
			$('.span_name').css('visibility','visible');
		}
		else{
			$('.span_name').css('visibility','hidden');
		}
	});
	
	$('#good-description').blur(function(){
		var value=$(this).val();
		//\u4e00-\u9fa5匹配汉字，a-zA-Z匹配字母，\d或者(0-9)匹配数字，,.，。匹配逗号和句号，^表示非，+表示尽可能多的匹配。
		var reg=new RegExp("[\u4e00-\u9fa5a-zA-Z0-9,\.，。]+");
		if(!reg.test(value)){
			 $('.div_black1').css('visibility','visible');
		     $('.div_iterm1').css('visibility','visible');
		}
		else{
			$('.div_black1').css('visibility','hidden');
		    $('.div_iterm1').css('visibility','hidden');
		}
		
		
	});
	
	$('.close_btn').click(function(){
		$('.div_black').css('visibility','hidden');
	    $('.div_iterm').css('visibility','hidden');
    });
	$('.close_btn1').click(function(){
		document.getElementById('good-description').value = '';
		$('.div_black1').css('visibility','hidden');
	    $('.div_iterm1').css('visibility','hidden');
    });
	
	$('.good-price').blur(function(){
		var value=$(this).val();
		//判断字符串如果是整数不能以0开头后面加正整数，如果是浮点数整数部分不能为两个0：如00.00
		var reg=new RegExp("^(([1-9][0-9]*\.[0-9][0-9]*)|([0]\.[0-9][0-9]*)|([1-9][0-9]*)|([0]{1}))$");   
		//alert(reg);
		if(!reg.test(value)){
			 $('.span_price').css('visibility','visible');
		}
		else{
			$('.span_price').css('visibility','hidden');
		}
	});
//	$('.good-type').blur(function(){
//		var value=$(this).val();
//		var reg=new RegExp("[A-Za-z0-9\u4e00-\u9fa5]+$");
//		if(!reg.test(value)){
//			$('.span_name').css('visibility','visible');
//		}
//		else{
//			$('.span_name').css('visibility','hidden');
//		}
//	});
	
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


