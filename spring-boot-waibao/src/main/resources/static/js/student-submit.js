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

function tip(content){
  //传参
  if ($.trim(content)=="最新公告") {
    $(".release").css("display","none");
  }
  //点击关闭
  $(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});
}