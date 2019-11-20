$(document).ready(function (){ 
    $('.list-message').hide(); //打开页面隐藏下拉列表 
    $('.list-one').hover( //鼠标滑过导航栏目时 
        function(){ 
            $('.list-message').show(); //显示下拉列表 
            $(this).css({'color':'','opacity':'0.7'}); //设置导航栏目样式，醒目 
        } 
    ); 
    $('.list-message').hover( //鼠标滑过下拉列表自身也要显示，防止无法点击下拉列表 
        function(){ 
            $('.list-message').show(); 
         }, 
        function(){ 
            $('.list-message').hide(); 
            $('.list-one').css({'color':'white'}); //鼠标移开下拉列表后，导航栏目的样式也清除 
        } 
    ); 
    $('li').hover(
        function(){ 
            $('.list-one').css({'color':'white'}); //鼠标移开下拉列表后，导航栏目的样式也清除 
            $(this).css({'text-decoration':'underline '}); 
         },
         function(){ 
            $(this).css({'text-decoration':'none '}); 
         }
    );
    // $('.list-message').hover( //鼠标滑过下拉列表是改变当前栏目样式 
    //     function(){ 
    //         $(this).css({'color':'red','background-color':'orange'}); 
    //     }, 
    //     function(){ 
    //         $(this).css({'color':'white','background-color':'black'}); 
    //     } 
    // ); 
    
}); 