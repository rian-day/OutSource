$(function () {

            //方法二：
    (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    })(jQuery);

    var grade = $.getUrlParam('grade');
    var correct = $.getUrlParam('correct');
    $(".exam-score ").text(grade);
    $(".content").text(correct);
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

