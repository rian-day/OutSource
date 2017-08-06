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
if (ye == null || ye == "") {
    ye = 1;
}
//获得总页数
pp = ($(".hidespan:last").text()) * 1;
$("#page").Page({
    totalPages: pp, //分页总数
    liNums: limit, //分页的数字按钮数(建议取奇数)
    activeClass: 'activP', //active 类样式定义
    callBack: function(page) {
        window.location.href = myurl + "?nowPage=" + page + "&size=6";
    }
})


$(".chakan").click(function(){
   time = $(this).parent().prev().children(".timelong:first").children('span').eq(1).text();

   var examId = $(this).parent().prev().children(".hidespan").text();
   var args = {
    "time":time
   }
   console.log(args);
//   $.post("createExamByGroup.do",args,function(data){
//	   	alert(data);
//	   	examId=data;
//   })
   $.ajax({
		url: 'createExamByGroup.do',
		type: 'POST',
		data: args,
		success : function(json){
			var data =JSON.parse(json);
			//alert(data);
		   	var examId=data;
//		   	var local = $(this).children("a").attr("href") + "?time=" + time+"&examid="+examId;
//		    alert(local);
//		    $(this).children("a").attr("href",local);
		    window.location.href="/student-test.html?time="+time+"&examid="+examId;
		}
	});
   
})

$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});


$.fn.smartFloat = function() {
 var position = function(element) {
  var top = element.position().top, pos = element.css("position");
  $(window).scroll(function() {
   var scrolls = $(this).scrollTop();
   if (scrolls > top) {
    if (window.XMLHttpRequest) {
     element.css({
      position: "fixed",
      top: "30%"
     }); 
    } else {
     element.css({
      top: scrolls
     }); 
    }
   }else {
    element.css({
     position: pos,
     top: top
    }); 
   }
  });
 };
 return $(this).each(function() {
  position($(this));      
 });
};


$(".release").smartFloat($(this));