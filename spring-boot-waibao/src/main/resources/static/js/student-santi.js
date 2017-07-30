
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
		"background-image": ''
	});
	$(this).css({
		"background-image": 'url(../static/images/true.png)'
	});	
	 time = ($(this).children('span').text());
})

$(".btn-primary").click(function(){
  if(time==""||time==null){
    alert("请选择时间");
  }else{
    var local = "student-test.html?time=" + time;
      window.location.href=local;
   }
})
$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
