$(document).ready(function () {
    var success="";
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

    //填写手机号
    $("input[name=phone]").blur(function () {
        if ($(this).val() == "") {
            $("#phone_check").text("请输入手机号");
        }
        reg = /\d{11}/;
        if (!reg.test($(this).val())) {
            $("#phone_check").text("请填写11位数字");
        }
        else {
            $.ajax({
                data: { "account": account, "phone": $("input[name=phone]").val() },
                url: "/account/check_account_phone_match",
                success: function (msg) {
                    if (msg == "0") {
                        $("#phone_check").text("手机与账号不匹配");
                    } else {
                        $("#phone_check").text("");
                        phone_ok = true;
                    }
                }
            });
        }
    })


    function checkVerify(o) {
          $('.form-control:disabled')
        var length = $(o).val().length;
        if (length == 0) {
            $('#captcha_check').text('请填写验证码!')
        } else if (length == 4) {
            $.ajax({
                url: "/check_captcha",
                data: { user_captcha_text: $("input[name=captcha_text]").val() },
                success: function (msg) {
                    if (msg == "success") {
                        captcha_ok = true;
                        $("#captcha_check").text("");

                        $('.form-control').attr('disabled','true');
                    }
                    else {
                        $("#captcha_check").text("验证码错误");
                        $("#captcha_img").attr('src', "/gen_captcha?" + Math.random());
                    }
                }
            });
        } else {

        }
    }
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


    $("#reset_pwd_btn").click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        if (account_ok == true && phone_ok == true && captcha_ok == true) {
            time(this);
            $.ajax({
                url: "/account/sms_new_pwd",
                data: { phone: $("input[name=phone]").val(), account: account},
                dataType: "json",
                success: function (msg) {
                    if (msg.status == "success") {
                        alert("新密码已发送到您的手机，请及时查收");
                        window.location.href = msg.redirect_url;
                    }else if (msg.status == "alert") {
                        alert(msg.msg);
                    }else {
                        alert("发送失败，请稍候再试！");
                    }
                }
            });
        }
        else {
            account_ok == false;
            phone_ok == false;
            captcha_ok == false;
            return;
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
            var url = "";
            var args = {
                "mail":mail
            }
            $.post(url,args,function(data){
                if(data == "0"){//不能找到该用户
                    $("#account_check").html("该邮箱不存在");
                }else{
                    //找到该用户
                    $("#account_check").html("验证码已经发送，请注意查收");
                    //一分钟倒计时
                    countDown();
                }
            })
        }
        // if (success=="") {
        //     $(".find_pwd_box").css("display","none");
        //     $(".find_pwd_box2").css("display","block");
        // }
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
