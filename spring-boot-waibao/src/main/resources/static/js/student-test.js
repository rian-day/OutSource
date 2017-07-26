
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

var answer = new Array();
var id = new Array();
var i = 0;
var length = $("dl").length;
$(".index").each(function(w){
	id[w] = $(this).next().text();
	answer[w] = "";	
})
$(".answer").click(function() {
    $(this).parent().find("dd").each(function() {
    	var background_color = $(this).css("background-color");
    	if(background_color == "rgb(93, 156, 236)"){
    		flag = "checked";
    		$(this).css({
                "background-color": "rgba(0, 0, 0, 0)",
                "color": "#707070"
            });
    		return;
    	}
    })
    $(this).css({
        "background-color": "rgb(93, 156, 236)",
        "color": "white"
    }); 
    var ANSWER = $(this).find(".ABCD").text();
    $(this).parent().find("dt").find(".indexLabel").each(function() {
    	var i = $(this).children(".index").text()-1;//试卷题号
    	answer[i] = ANSWER;
    })
})

$(".input").change(function() {
	var ANSWER = ($(this).val());
    $(this).parents(".answerInput").prev().find(".indexLabel").each(function() {
    	var i = $(this).children(".index").text()-1;//试卷题号
    	answer[i] = ANSWER;
    })
})

$(".input").click(function() {
	$(this).css({
		"border":"0",
		"border-bottom":"1px solid black"
    })
})

$(".answerMuch").click(function() {
	var background_color = $(this).css("background-color");
    var ANSWER = "";
    if(background_color == "rgb(93, 156, 236)"){
		$(this).css({
            "background-color": "rgba(0, 0, 0, 0)",
            "color": "#707070"
        });    
	}else{
		$(this).css({
            "background-color": "rgb(93, 156, 236)",
            "color": "white"
        });       	    
	}
	$(this).parent().find("dd").each(function() {
    	background_color = $(this).css("background-color");
    	if(background_color == "rgb(93, 156, 236)"){
    		ANSWER += $(this).find(".ABCD").text();
    	}
	})
    $(this).parent().find("dt").find(".indexLabel").each(function() {
    	var i = $(this).children(".index").text()-1;//试卷题号
   		answer[i] = ANSWER;
    })
})

$(".datikaImg").click(function(){
	var danxuanLength = $("#danxuan").length;
	var duoxuanLength = $("#duoxuan").length;
	var tiankongLength = $("#tiankong").length;
	var j = 0;
	var str1,str2,str3;
	var l =1;
	for(j = 0;j<danxuanLength;j++){
		if(answer[j] == ""||answer[j] == null){
			str1 = "<label><span class='th'>"+l+"</span><span class='da'>空</span></label>";
		}
		else{	
			str1 = "<label><span class='th'>"+l+"</span><span class='da'>"+answer[j]+"</span></label>";
		}
		l++;

	}
	for(;j<danxuanLength+duoxuanLength;j++){
		if(answer[j] == ""||answer[j] == null){
			str2 = "<label><span class='th'>"+l+"</span><span class='da'>空</span></label>";
		}
		else{	
			str2 = "<label><span class='th'>"+l+"</span><span class='da'>"+answer[j]+"</span></label>";
		}
		l++;
	}
	for(;j<danxuanLength+duoxuanLength+tiankongLength;j++){
		if(answer[j] == ""||answer[j] == null){
			str3 = "<label><span class='th'>"+l+"</span><span class='da'>空</span></label>";
		}
		else{	
			str3 = "<label><span class='th'>"+l+"</span><span class='da'>"+answer[j]+"</span></label>";
		}
		l++;
	}
	$(".div1").html(str1);
	$(".div2").html(str2);
	$(".div3").html(str3);
 $(".datika").css("display","block");

})

$(".list-view").not($(".gb")).click(function(){
	$(".datika").css("display","none");
})

$(".gb").click(function(){
	$(".datika").css("display","none");
})



setInterval("sub()",1000);
function sub(){
	if($("#tiles").text() == "00:00:00"){
    alert("考试时间已经到了");
		submit();
	}
}
 //$(".submitImg").on("click",submit());
function submit(){
	var url = "submitTest.do";
	var args = {
		"id":id,
		"answer":answer
	}
	$.post(url,args,function(data){
    var grade = data.grade;
    var correct = data.correct;
		window.location.href="student-submit.html?grade='"+grade+"'&correct='"+correct+"'";
  

	})
}


$(".submitImg").click(function(){
    $(".window").animate({"top":"20%"});
    $(".window").smartFloat($(this));
})
$(".windowbutton1").click(function() {
	/* Act on the event */
	$(".window").animate({"top":"-350px"});
});


$(".windowbutton2").click(function() {
  /* Act on the event */
  submit();
});
$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
