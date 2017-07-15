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
    var local = $(this).children("a").attr("href") + "?id=" + id;
    $(this).children("a").attr("href", local);
})
})

window.onload=function(){
    var studentuId = $(".spanhide").text();
    var url = "";
    var args = {
        //学生的id
        "id":studentuId
    }
    $.post(url,args,function(data){
        
    })
}