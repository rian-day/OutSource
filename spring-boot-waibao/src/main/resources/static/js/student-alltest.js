$(function() {
	window.onload = a();
	var page = "";
	function a(){
		var url = "selectAlltest.do";
		var args = {
				"page":1
		}
		$.post(url,args,function(data){
			page = data;
		})
	}
    //分页
    $("#page").Page({
        totalPages: page, //分页总数
        liNums: 7, //分页的数字按钮数(建议取奇数)
        activeClass: 'activP', //active 类样式定义
        callBack: function(page) {
            //console.log(page)
        }
    });
    
    $(".pagingUl li").click(function() {
        var page = $(this).children("a").text();
        var id = $(".hidespan").text();
        var url = "selectAlltest.do";
        var args = {
            "page": page
        }
        $.post(url, args, function(data) {

        })
    })
    $(".chakan").click(function(){
        var number = $(this).parent().prev().children(".timelong").eq(0).children("span").eq(1).text();
        var status = "yes";
        alert(number);
        var obj = new Object();
        obj.time=number;
        obj.statu=status;
        window.showModalDialog("student-test.html",obj,"dialogWidth=200px;dialogHeight=100px");

    })
})

// $(".chakan").click(function(){
//    id = $(this).parent().prev().children(".hidespan").text();
//    var local = $(this).children("a").attr("href") + "?id=" + id;
//    alert($(this).children("a").attr("href"));
//    $(this).children("a").attr("href",local);
// })


