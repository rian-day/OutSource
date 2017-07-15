
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
		url = "";

	}
	else{
		//取消收藏
		$(this).attr("class","collect");
		$(this).next().text("收藏");
		url = "";

	}
	var args = {
		"id":id
	}
	$.post(url,args,function(data){

	})

})

window.onload=function(){
	function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    var id = getUrlParam("id");
	var url = "";
	var args = {
		//试卷的id
		"id":id
	}
	$.post(url,args,function(data){
		
	})
}
