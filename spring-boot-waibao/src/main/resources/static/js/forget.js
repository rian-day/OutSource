$(document).ready(function () {
    var success="-1";
    var account_ok = false;
    var phone_ok = false;
    var captcha_ok = false;
    var account = "";
    var filter1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var filter2 = /^([a-zA-Z0-9_\.\-])+\@([0-9])+$/;
    var filter3 = /^([a-zA-Z0-9_\.\-@])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    //填写账号
    // $("input[name=account]").blur(function () {
    //     account = "";
    //     if ($(this).val() == "") {
    //         $("#account_check").text("请输入登录账号");
    //         success=1;
    //     } else {
    // 	    if(domain){   
    //             if(filter1.test($(this).val())||filter2.test($(this).val())){
    //                 //独立入口
    //                 account=$(this).val()
    //             } else {
    //                 account = $(this).val() + "@" + domain;
    //             }
    //         } else {
    //                 //公共入口
    //             if(filter1.test($(this).val())||filter2.test($(this).val())||(/^1(3|4|5|7|8)\d{9}$/.test($(this).val()))){
    //                 $("#account_check").text("")
    //                 account = $(this).val()
    //             } else {
    //                 success=1;
    //                 $("#account_check").text("账号不存在")
    //             }
    //         }
    //         $.ajax({
    //             type: "GET",
    //             cache: false,
    //             headers: { "cache-control": "no-cache" },
    //             dataType: "text",
    //             url: "/account/check_account_exist?account=" + account,
    //             success: function (msg) {
    //                 if (msg == "0") {
    //                     success=1;
    //                     $("#account_check").text("账号不存在");
    //                 } else {
    //                     $("#account_check").text("");
    //                     account_ok = true;
    //                 };
    //             }
    //         });
    //     };
    // })



    //点击获取验证码事件
    var wait = 60;
    function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");
            o.value = "免费获取验证码";
            wait = 60;
        } else {
            o.setAttribute("disabled", true);
            o.value = "重新发送(" + wait + ")";
            wait--;
            setTimeout(function () {
                time(o);
            }, 1000);
        };
    }
    $("input[name=captcha_text]").keyup(function () {
        checkVerify($("input[name=captcha_text]"));

    })


    $("#reset_pwd_btn").click(function () {
    	if (success=="1") {
            var resetPwd1 = $(".resetPwd1").val();
            var resetPwd2 = $(".resetPwd2").val();
            if(resetPwd1 == ""||resetPwd1 == null||resetPwd2 == ""||resetPwd2 == null)
            	$("#account_check").html("密码不能为空");
            else if(resetPwd1 != resetPwd2){
            	$("#account_check").html("两次输入的密码不一致");
            }else if(resetPwd1.length<6)
            	$("#account_check").html("密码长度大于6");
            else{
            	var url = "edit.do"
            	var args = {
            			"mail":mail,
            			"password":resetPwd1
            	}	
            	$.post(url,args,function(data){
            		if(data == 0){
            			$("#account_check").html("密码重置失败");
            		}else if(data == 1)
            			 window.location.href = 'student-info.html';
            	})
            }            
        }else if(success == 0){
        	 var yzm = $(".yanzheng").val();
        	 var url1 = "checkYzm.do";
        	 var args ={
        			 "yzm":yzm
        	 }
        	 
        	 $.post(url1,args,function(data){
        		 if(data == 1){
        			 $(".find_pwd_box").css("display","none");
        			 $(".find_pwd_box2").css("display","block");
        			 success = "1";
        		 }else if(data == 0){
        			 $("#account_check").html("验证码错误");
        		 }
        	})
        	 
             
        }else{
            if($(".validateCode").val() == "" || $(".validateCode").val() == null){
                $("#account_check").html("邮箱不能为空");
            }else if(!($(".validateCode").val()).match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/))
                $("#account_check").html("邮箱格式不正确");
            else{
            	$("#account_check").html("验证码不正确");
            }
        }
    });

    var mail = "";
    $(".yanzheng").click(function() {
        mail = $(".form-control").val();
        if(mail == "" || mail == null){
            $("#account_check").html("邮箱不能为空");
        }else if(!(mail).match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/))
            $("#account_check").html("邮箱格式不正确");
        else{
            var url = "yzm.do";
            var args = {
                "mail":mail
            }
            $.post(url,args,function(data){
                if(data == "0"){//不能找到该用户
                    $("#account_check").html("该邮箱不存在");
                }else if(data == 1){
                    //找到该用户
                    $("#account_check").html("验证码已经发送，请注意查收");
                    success = "0";
                    //一分钟倒计时
                    countDown();
                }
            })
        }
         
    });

    var countdowm = 60;
    function countDown(){
        if (countdown == 0) {
            $(".yanzheng").attr("disabled", "");
            $(".yanzheng").value = "重新发送";
            countdown = 60;
            return;
        } else {
            $(".yanzheng").attr("disabled", "true");
            $(".yanzheng").attr("value","重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
            countDown()
        }, 1000)
    }

})
