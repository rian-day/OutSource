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

var answer = new Array();
var id = new Array();
var i = 0;
var length = $("dl").length;
$(".index").each(function(w) {
    $(this).text(w + 1);
    id[w] = $(this).next().text();
    answer[w] = "";
})
$(".answer").click(function() {
    $(this).parent().find("dd").each(function() {
        var background_color = $(this).css("background-color");
        if (background_color == "rgb(93, 156, 236)") {
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
        var i = $(this).children(".index").text() - 1; //试卷题号
        answer[i] = ANSWER;
    })
})

$(".input").change(function() {
    var a = "";
    var i = 0;
    $(this).parents(".answerInput").prev().find(".indexLabel").each(function() {
        i = $(this).children(".index").text() - 1; //试卷题号
    })
    $(this).parents().children(".input").each(function(c) {
        var ANSWER = ($(this).val());
        if (c != 0) {
            a = a + "," + ANSWER;
        } else {
            a = ANSWER;
        }

    })
    answer[i] = a;
})

$(".input").click(function() {
    $(this).css({
        "border": "0",
        "border-bottom": "1px solid black"
    })
})

$(".answerMuch").click(function() {
    var background_color = $(this).css("background-color");
    var ANSWER = "";
    if (background_color == "rgb(93, 156, 236)") {
        $(this).css({
            "background-color": "rgba(0, 0, 0, 0)",
            "color": "#707070"
        });
    } else {
        $(this).css({
            "background-color": "rgb(93, 156, 236)",
            "color": "white"
        });
    }
    $(this).parent().find("dd").each(function() {
        background_color = $(this).css("background-color");
        if (background_color == "rgb(93, 156, 236)") {
            ANSWER += $(this).find(".ABCD").text();
        }
    })
    $(this).parent().find("dt").find(".indexLabel").each(function() {
        var i = $(this).children(".index").text() - 1; //试卷题号
        answer[i] = ANSWER;
    })
})

$(".datikaImg").click(function() {
    var str = "";
    for (var l = 0; l < answer.length; l++) {
        if (answer[l] == "" || answer[l] == null) {
            str += "<label><span class='th'>" + (l + 1) + "</span><span class='da'>&nbsp;</span></label>";
        } else {
            str += "<label><span class='th'>" + (l + 1) + "</span><span class='da'>" + answer[l] + "</span></label>";
        }

    }
    $(".s").html(str);
    $(".datika").css("display", "block");

})

$(".list-view").not($(".gb")).click(function() {
    $(".datika").css("display", "none");
})

$(".gb").click(function() {
    $(".datika").css("display", "none");
})



setInterval("sub()", 1000);

function sub() {
    if ($("#tiles").text() == "00:00:00") {
        alert("考试时间已经到了");
        submit();
    }
}
//$(".submitImg").on("click",submit());
function submit() {
	var examId=$("#hyhExamId").text();
    var list = new Array();
    var url = "submitTest.do";
    for(var i = 0;i<length;i++){
        var o = new Object();
        o.id = id[i];
        o.answer = answer[i];
        list[i] = o;
    }
    var args = {
        "list" : JSON.stringify(list),
        "examId" : examId
    }
    console.log(args);
    $.post(url, args, function(data) {
        var grade = data;
        window.location.href = "student-submit.html?grade='" + grade + "'&correct='20%'";

    })
}


$(".submitImg").click(function() {
    $('#myModal').modal('show');
})



$(".submit").click(function() {
    /* Act on the event */
    submit();
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

