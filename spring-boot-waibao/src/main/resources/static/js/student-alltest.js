$(function() {
	
    //分页
    var pp= $(".hidespan:last").text() * 1;
    window.onload=a();
    function a(){
        $("#page").Page({
            totalPages: pp, //分页总数
            liNums: 7, //分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack: function(page) {
                var url = "selectAlltest.do";
                var args = {
                    "page":page
                }
                $.post(url,args,function(data){

                })
            }
        });
    }
   



    //点击页数跳转到指定页数

    
  
})

$(".chakan").click(function(){
   time = $(this).parent().prev().children(".timelong:first").children('span').eq(1).text();
   var local = $(this).children("a").attr("href") + "&time=" + time;
   $(this).children("a").attr("href",local);
   
})

$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
