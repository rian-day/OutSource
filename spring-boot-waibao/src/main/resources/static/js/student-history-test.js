
$("span[name='collect']").mouseenter(function(){

	var l = $(this).attr("class");
	if(l == "collect"){
		$(this).next().text("收藏");
	}
	else{
		$(this).next().text("取消收藏");
	}
	$(this).next().text();
	$(this).next().css("visibility", "visible");

})

$("span[name='collect']").mouseleave(function(){
	$(this).next().css("visibility","hidden");
})




$("span[name='collect']").click(function(){
	var l = $(this).attr("class");
	var id = $(this).prev().text();
	var url = "";
	if(l == "collect"){
		//收藏
		$(this).attr("class","collected");
		$(this).attr("class","collected")
		$(this).next().text("取消收藏");
		url = "collect.do";
	}
	else{
		//取消收藏
		$(this).attr("class","collect");
		$(this).next().text("收藏");
		url = "cancelCollect.do";
	}
	var args = {
		"id":id
	}
	$.post(url,args,function(data){

	})

})

// window.onload=function(){
// 	function getUrlParam(name) {
//         var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
//         var r = window.location.search.substr(1).match(reg);  //匹配目标参数
//         if (r != null) return unescape(r[2]); return null; //返回参数值
//     }
//     var id = getUrlParam("id");
// 	var url = "";
// 	var args = {
// 		//试卷的id
// 		"id":id
// 	}
// 	$.post(url,args,function(data){
		
// 	})
// }


$(document).ready(function() {
	sendMessage();
})
function sendMessage(){
	$.ajax({
		url: '/pushMessage.do',
		type: 'POST',
		success : function(data){
			if(data!=null){
				tip(data);
			}
			setTimeout(function(){sendMessage()},5000);
		}
	});
}
function tip(content){
  //传参
  if ($.trim(content)=="") {
    $(".release").css("display","none");
  }else{
  $(".release").css("display","block");
    $(".release-content").html('<span class="glyphicon glyphicon-remove"></span>'+content);
    $(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
    });
  }
}

