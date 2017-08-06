$(document).ready(function() {



    $(".Emails").focus(function() {
        $(".Emails").css("border", "2px solid red");
    });
    $(".Emails").blur(function() {
        $(".Emails").css("border", "2px solid rgb(230,230,230)");
    });

    $(".Passwords").focus(function() {
        $(".Passwords").css("border", "2px solid red");
    });
    $(".Passwords").blur(function() {
        $(".Passwords").css("border", "2px solid rgb(230,230,230)");
    });


    $(".denglu input").mousemove(function() {
        $(".denglu input").css("background", "green")
    });




    //�л�login��sign
    $(".sss").click(function() {
        $(".loginul").css("display", "none");
        $("#signup").css("display", "block");
        
        if ($(".ss").text() == "ע��") {
            $(".ss").children("span").text("��¼");
            $(".ss").attr("href","javascript:void(0)");
        }
    });
    $(".ss").click(function(){
        $(".loginul").css("display", "none");
        $("#signup").css("display", "block");
        
        if ($(this).text() == "ע��") {
            $(this).children("span").text("��¼");
            $(this).attr("href","javascript:void(0)");
        }else if($(this).text() == "��¼"){
        	$(".ss").children("span").text("ע��");
            $(".ss").attr("login.html");
            $(".loginul").css("display", "block");
            $("#signup").css("display", "none");
        }
    });
    $(".qqq").click(function() {
        $(".loginul").css("display", "block");
        $("#signup").css("display", "none");
        if ($(".ss").text() == "��¼") {
            $(".ss").children("span").text("ע��");
            $(".ss").attr("login.html");
        }
    });






    //signup		
    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches


    $(".next").click(function() {
        if (animating) return false;
        animating = true;

        current_fs = $(this).parent();
        next_fs = $(this).parent().next();

        //activate next step on progressbar using the index of next_fs
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

        //show the next fieldset
        next_fs.show();
        //hide the current fieldset with style
        current_fs.animate({ opacity: 0 }, {
            step: function(now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale current_fs down to 80%
                scale = 1 - (1 - now) * 0.2;
                //2. bring next_fs from the right(50%)
                left = (now * 50) + "%";
                //3. increase opacity of next_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({ 'transform': 'scale(' + scale + ')' });
                next_fs.css({ 'left': left, 'opacity': opacity });
            },
            duration: 800,
            complete: function() {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

    $(".previous").click(function() {
        if (animating) return false;
        animating = true;

        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();

        //de-activate current step on progressbar
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

        //show the previous fieldset
        previous_fs.show();
        //hide the current fieldset with style
        current_fs.animate({ opacity: 0 }, {
            step: function(now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale previous_fs from 80% to 100%
                scale = 0.8 + (1 - now) * 0.2;
                //2. take current_fs to the right(50%) - from 0%
                left = ((1 - now) * 50) + "%";
                //3. increase opacity of previous_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({ 'left': left });
                previous_fs.css({ 'transform': 'scale(' + scale + ')', 'opacity': opacity });
            },
            duration: 800,
            complete: function() {
                current_fs.hide();
                animating = false;
            },
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

    $(".submit").click(function() {
        return false;
    })


    var alertTxt = new Array("�˺Ų���Ϊ��", "�����ʽ����ȷ", "���벻��Ϊ��", "�˺Ż����������", "�������ٺ���6���ַ�", "�����������벻һ��", "", "���䲻��Ϊ��", "��������Ϊ��", "��֤�벻��Ϊ��");
    var table, email, password;
    //��ȡinput
    $("#s1").click(function() {
        $(".Email1").val(
            $(".Email").val()
        )
    });
    $("#s1").click(function() {
        var i = 6;
        if ($(".name").val().length == 0) {
            i = 8;
        } else if ($(".pass").val().length == 0) {
            i = 2;
        } else if ($(".pass").val().length < 6) {
            i = 4;
        } else if ($(".pass").val() != $(".cpass").val()) {
            i = 5;
        } else {
            if (animating) return false;
            animating = true;
            current_fs = $(this).parent();
            next_fs = $(this).parent().next();
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
            next_fs.show();
            current_fs.animate({ opacity: 0 }, {
                step: function(now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale current_fs down to 80%
                    scale = 1 - (1 - now) * 0.2;
                    //2. bring next_fs from the right(50%)
                    left = (now * 50) + "%";
                    //3. increase opacity of next_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({ 'transform': 'scale(' + scale + ')' });
                    next_fs.css({ 'left': left, 'opacity': opacity });
                },
                duration: 800,
                complete: function() {
                    current_fs.hide();
                    animating = false;
                },
                //this comes from the custom easing plugin
                easing: 'easeInOutBack'
            });
        }
        $(".prompt1").html(alertTxt[i]);
        $(".prompt1").fadeIn();
    });
    // ��¼
    $("#loginSubmit").click(function() {
            table = $("input[type='radio']:checked").next().text();
		if ($.trim(table)== "����Ա")
                table = "1";
            else
                table = "0";
            email = $(".Emails").val();
            password = $('.Passwords').val();
            if (email == null || email == "") {
                $(".loginalert").html(alertTxt[0]);
            } else if (!(email).match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
                $(".loginalert").html(alertTxt[1]);
            } else if (password == null || password == "") {
                $(".loginalert").html(alertTxt[2]);
            } else {

                var args = "";
                args = {
                    "username": email,
                    "password": password,
                    "boss": table
                }
		    console.log(args.boss);
                var url = "login.do";
                $.post(url, args, function(data) {
                	if(data==2){
                		window.location.href="spmanage-applylist.html";
                	}
                	if(data==1){
                        if(table == "0")
                            window.location.href="student-index.html";
                        else
                             window.location.href="manage-index.html"
                	}else
                        $(".loginalert").html(alertTxt[3]);
                })
            }
        })
        //ע��
    $("#regSubmit").click(function() {
        var mail = $(".Email").val();
        var pass = $('.pass').val();
        var name = $(".name").val();
        var pro = $("#myselect option:checked").val();
        var sex = $("#sex option:checked").val();
        var yzm = $(".yzm").val();
        console.log(pro);
        var args = "";
        if (yzm == "" || yzm == null) {
            $(".prompt2").html(alertTxt[9]);
        }else{
	        args = {
	        	"username":mail,
	        	"password":pass,
	        	"name":name,
	        	"professionId":pro,
	        	"yzm":yzm,
	        	"sex":sex
	         	}
	       
	        url = "register.do";
	        $.post(url,args,function(data){
         		if(data == 1){
         			$("#myModal").modal('show');
         		}else{
         			$("#errorModal").modal('show');
         		}
	        })
	    }

    })
    //
    $("#yanzheng1").click(function(){
        var mail = $(".Email").val();
        var url = "yzm.do";
        args = {
            "mail":mail
        }
        $.post(url,args,function(data){});
    })
    //ְҵ��ȡ
    window.onload=function(){
        var url = "";

        $.post(url,"",function(data){
            
        })
    }
});

var countdown = 60;

function settime(obj,flag) {
    var al = "";
    if ($(".Email").val()==""||$(".Email").val()==null) {
        al = "���䲻��Ϊ��";
    }
    else if (!$(".Email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
        al = "�����ʽ����ȷ";
    }
    else{
        if(flag == "1"){
                al = "��֤���ѷ��ͣ������ĵȴ�"
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.value = "���·���";
                countdown = 60;
                return;
            } else {
                obj.setAttribute("disabled", true);
                obj.value = "���·���(" + countdown + ")";
                countdown--;
            }
        }
        
        setTimeout(function() {
            settime(obj,"1")
        }, 1000)
    }
    $(".prompt2").html(al);
}

$(".laji").click(function(){
    $(this).parent().hide();
});