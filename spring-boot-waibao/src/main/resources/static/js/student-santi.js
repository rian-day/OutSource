
var time;
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


$(".a_demo_four").click(function(){
    $(".window").animate({"top":"20%"});
    $(".window").smartFloat($(this));
})
$(".windowbutton1").click(function() {
	/* Act on the event */
	$(".window").animate({"top":"-350px"});
});

$(".time").click(function(){
	$(".time").css({
		"background-image": '',
    "color": 'black'
	});
	$(this).css({
		"background-image": 'url(../static/images/true.png)',
    "color": 'red'
	});	
	 time = ($(this).children('span').text());
})

$(".btn-primary").click(function(){
  if(time==""||time==null){
    alert("请选择时间");
  }else{
    var args = {
      "time":time
    }
    $.ajax({
		url: 'createExamRandom.do',
		type: 'POST',
		data: args,
		success : function(json){
			var data =JSON.parse(json);
			//alert(data);
		   	examId=data;
//		   	var local = $(this).children("a").attr("href") + "?time=" + time+"&examid="+examId;
//		    alert(local);
//		    $(this).children("a").attr("href",local);
		    window.location.href="/student-test.html?time="+time+"&examid="+examId;
		}
	});

//    var local = "student-test.html?time=" + time;
//      window.location.href=local;
   }
})
$(".left-shadow").mouseover(function() {
    $(".left-shadow").css("display","none");
});
$(".left-shadow").mouseleave(function() {
    $(".left-shadow").css("display","block");
});
$(".right-shadow").mouseover(function() {
    $(".right-shadow").css("display","none");
});
$(".right-shadow").mouseleave(function() {
    $(".right-shadow").css("display","block");
});

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

