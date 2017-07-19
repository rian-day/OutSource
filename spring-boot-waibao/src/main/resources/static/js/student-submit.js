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