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


//分页
var ye = 0; //当前页数
var limit = 5; //分页的数字按钮数(建议取奇数)
var pp = ($(".hidespan:last").text()) * 1;
var www = window.document.location.href;
var myurl = www.substring(0, www.indexOf('?'));

//截取
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}
ye = getUrlParam("nowPage");
if(ye == null || ye ==""){
    ye = 1;
}
//获得总页数
pp = ($(".hidespan:last").text()) * 1;
$("#page").Page({
    totalPages: pp, //分页总数
    liNums: limit, //分页的数字按钮数(建议取奇数)
    activeClass: 'activP', //active 类样式定义
    callBack: function(page) {
        window.location.href = myurl + "?nowPage=" + (page-1) + "";
    }
})

//分页请求页面
var url = "selectHistory.do";
var args = {
    "page":ye - 1
}
$.post(url,args,function(data){

})

$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
