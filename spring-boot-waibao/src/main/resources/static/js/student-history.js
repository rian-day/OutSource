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

var page = 0;
window.onload=function(){
    var studentuId = $(".spanhide").text();
    var url = "selectHistory.do";
    $.post(url,args,function(data){
        page = data;
    })
}

$(function(){
	$("#page").Page({
    totalPages: 9, //分页总数
    liNums: 7, //分页的数字按钮数(建议取奇数)
    activeClass: 'activP', //active 类样式定义
    callBack: function(page) {
        //console.log(page)
    }
});
var id = "";

$(".chakan").on("click", function() {
    id = $(this).parent().prev().children(".hidespan").text();
    var url = "selectTest.do";
    var args = {
    		"id":id
    };
    $.post(url,args,function(data){
    	
    })
})
})

