$(".list-view").mouseenter(function() {
    $(".list-view div").show();
})

$(".list-view").mouseleave(function() {
    $(".pageChangeLeft ").hide();
    $(".pageChangeRight").hide();
})

$("table tr").mouseenter(function() {
    $(this).css({
        "background-color": "none"
    })
})
var id = "";
//跳转到相应试卷的历史纪录页面 查看试题
$(".chakan").on("click", function() {
    id = $(this).parent().prev().children(".hidespan").text();
    var url = "selectTest.do";
    var args = {
    		"id":id
    };
    $.post(url,args,function(data){
    	
    })
})


var pp = 0;
window.onload=function p(){
    pp = ($(".hidespan:last").text()) * 1;
    $("#page").Page({
        totalPages: pp,//分页总数
        liNums: 7,//分页的数字按钮数(建议取奇数)
        activeClass: 'activP', //active 类样式定义
        callBack : function(page){            
            var url = "selectHistory.do";
            var args = {
                "page":page
            }
            $.post(url, args, function(data) {
                /*optional stuff to do after success */
            });
        }
    });
}

$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
