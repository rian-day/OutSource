$(function() {
	$('.choose-value').click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass('active');
		} else {
			$(this).addClass('active');
		}
		$(this).parent().find('.choose-list').toggle();
	});
	
	// 选择选项后赋值
	$('.choose-item').click(function() {
		var _detail = $(this).text();
		var _value = $(this).attr("data-index");
		$(this).parent().parent().find(".choose-value").text(_detail);
		$(this).parent().parent().find(".choose-value").attr("data-index", _value);
		$(this).parent().hide();
		$('.choose-value').removeClass('active');
	});
	
	//点击其他区域隐藏下拉选项
	$(document).bind("click",function(e){ 
		var target = $(e.target); 
		if(target.closest(".choose-problem").length == 0){ 
			$(".choose-list").hide(); 
			$(".choose-value").removeClass("active"); 
		} 
	});
	
    var str1 = '<button type="button" class="btn btn-success save">保存</button>';
    var str2 = '<button type="button" class="btn btn-danger cancel">取消</button>';
    var str3 = '<button type="button" class="btn btn-success edit">编辑</button>';
    var value = "";
    $(".btn").on("click",function(){
    	$(".cuotibutton").css("display","none");   
    	var value = "";
    	if($(this).attr("class") == "btn btn-success edit"){
    		//编辑
    		$("#cuotibuttonId2").css("display","inline-block");
    		value = $(".analyse").text();
    		$(".analyse").css("display","none");
    		$("#editTxt").css("display","inline-block");
    		$("#editTxt").val(value);
    	}
    	else if($(this).attr("class") == "btn btn-danger cancel"){
    		$(".analyse").css("display","none");
    		$(".text").css("display","inline-block");
    	}else{
    		var analyse = $(".textarea1").val();
    		var url = "editAnalyse.do";
    		var args = {
    				"analyse":analyse
    		}
    		$.post(url,args,function(data){
    			
    		})
    		$(".analyse").css("display","none");
    		$(".text").css("display","inline-block");
    		$("#cuotibuttonId1").css("display","inline-block");
    	}   	
    })
    var p ;
    var array = new Array();
 	   	   
    //错题题查询 带条件查询
    $(".rightDiv button").click(function(){
    	$(".choose-value").each(function(i){
     		array[i] = $(this).text();
     	});   	
     	var args = {
     			"type":array[0],
     			"pro":array[1]
     	}
     	var url = "selectError.do";
     	$.post(url,args,function(data){
        var pp = data;
     		$("#page").Page({
     	          totalPages: pp,//分页总数
     	          liNums: 7,//分页的数字按钮数(建议取奇数)
     	          activeClass: 'activP', //active 类样式定义
     	          callBack : function(page){
                   var a = {
                      "type":array[0],
                      "pro":array[1],
                      "page":data
                   }
                    $.post(url,args,function(data){})
                }
     		}) 
        })  	
    })
	window.onload=p();
  function p(){
    var pp = ($(".hidespan:last").text()) * 1;
    $("#page").Page({
        totalPages: pp,//分页总数
        liNums: 7,//分页的数字按钮数(建议取奇数)
        activeClass: 'activP', //active 类样式定义
        callBack : function(page){            
            var url = "selectError.do";
            var args = {
                "page":page
            }
            $.post(url, args, function(data) {
                /*optional stuff to do after success */
            });
        }
    });
  }
	var queId;
   /******/
	$(".error-contain ul li").click(function(){
		var queId = $(this).children(".hidespan").text();
		
	})
	
	

});

