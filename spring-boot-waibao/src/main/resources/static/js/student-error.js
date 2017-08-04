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
$(document).bind("click", function(e) {
    var target = $(e.target);
    if (target.closest(".choose-problem").length == 0) {
        $(".choose-list").hide();
        $(".choose-value").removeClass("active");
    }
});

var str1 = '<button type="button" class="btn btn-success save">保存</button>';
var str2 = '<button type="button" class="btn btn-danger cancel">取消</button>';
var str3 = '<button type="button" class="btn btn-success edit">编辑</button>';
var text = "";
$(".btn").click(function() {
    $(this).parent().css("display", "none");
    if ($(this).attr("class") == "btn btn-success edit") {
        //编辑
        var c = $(this).parent().prev();
        text = c.children("div").text();
        c.children("div").css("display", "none");
        c.children("textarea").val(text);
        c.children("textarea").css("display","block");
        $(this).parent().next().css("display","block");
    } else if ($(this).attr("class") == "btn btn-danger cancel") {
        var c = $(this).parent().prev().prev();
        c.children("textarea").css("display", "none");
        c.children("div").css("display", "block");
        $(this).parent().prev().css("display","block");
    } else {
        var analyse = $(this).parent().prev().prev().children("textarea").val();
        console.log("analyse"+analyse);
        var url = "editAnalyse.do";
        var args = {
            "analyse": analyse,
            "queId":queId
        }
        $.post(url, args, function(data) {

        })
        var c = $(this).parent().prev().prev();
        c.children("textarea").css("display", "none");
        c.children("div").css("display", "block");
        c.children("div").text(analyse);
        $(this).parent().prev().css("display","block");
    }
})
var p;
var array = new Array("","");
var www = window.document.location.href;
var myurl = www.substring(0, www.indexOf('?'));

//错题题查询 带条件查询
var queId = $(".error-contain li:eq(0) .hidespan").text();
$(".rightDiv button").click(function() {
    $(".choose-value").each(function(i) {
        array[i] = $(this).text();
        if(array[i] == ""||array[i] == null||array[i] == undefined){
            array[i] = "";
        }
    });
    window.location.href = myurl + "?type=" + array[0] + "&pro=" + array[1];
})

var ye = 0; //当前页数
var limit = 5; //分页的数字按钮数(建议取奇数)
var pp = ($(".hidespan:last").text()) * 1;

//截取
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}
ye = getUrlParam("nowPage");
var pro = getUrlParam("pro");
if(pro == null)
    pro="";
var type = getUrlParam("type");
if(type == null)
    type="";
if (ye == null || ye == "") {
    ye = 1;
}
//获得总页数
pp = ($(".hidespan:last").text()) * 1;
$("#page").Page({
    totalPages: pp, //分页总数
    liNums: limit, //分页的数字按钮数(建议取奇数)
    activeClass: 'activP', //active 类样式定义
    callBack: function(page) {
        window.location.href = myurl + "?nowPage=" + page + "&type=" + type + "&pro=" + pro;
    }
})


$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name", "bounceoutL");
    $(".release").css("-webkit-animation-duration", "1s");
    $(".release").css("animation-fill-mode", "forwards");
});


$.fn.smartFloat = function() {
    var position = function(element) {
        var top = element.position().top,
            pos = element.css("position");
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
            } else {
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


$(".release").smartFloat($(this));


var long = $(".error-contain li").length;
console.log($(".error-contain li").length);

$(".timu-fenxi:eq(0)").css({
    "display": "block"
})

$(".error-contain ul li").click(function() {
    console.log($(this).index());
    var index = $(this).index();
    $(".timu-fenxi").css("display","none");
    var u = ".timu-fenxi:eq(" + index + ")";
    $(u).css({
        "display": "block"
    })
    queId = $(".error-contain li:eq(" + index + ") .hidespan").text();
    console.log("123:"+queId);
})



$("i").each(function(j) {
    $(this).text(j + 1);
});


