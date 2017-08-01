
    var success="-1";
    var account_ok = false;
    var phone_ok = false;
    var captcha_ok = false;
    var account = "";
    var filter1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var filter2 = /^([a-zA-Z0-9_\.\-])+\@([0-9])+$/;
    var filter3 = /^([a-zA-Z0-9_\.\-@])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var countdown = 60;
//点击提交
    $("#reset_pwd_btn").click(function () {
    	if (success=="1") {
    		//这里是重置密码二次输入
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
            		}else if(data == 1){
                        alert("修改成功，请登录。");
                        window.location.href = 'login.html';
                    }
            			 
            	})
            }            
        }else if(success == "0"){
        	//校对验证码
        	 var yzm = $(".yanzheng").val();
        	 var url1 = "checkYzm.do";
        	 var args ={
        			 "yzm":yzm
        	 }
        	 
        	 $.post(url1,args,function(data){
        		 console.log(data);
        		 if(data == 1){
        			 $(".find_pwd_box").css("display","none");
        			 $(".find_pwd_box2").css("display","block");
        			 success = "1";
        		 }else if(data == 0){
        			 $("#account_check").html("邮箱验证码错误");
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
//点击发送验证码
    var mail = "";
    $(".yanzheng").click(function() {
        mail = $(".form-control").val();
        if(mail == "" || mail == null){
            $("#account_check").html("邮箱不能为空");
        }else if(!(mail).match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/))
            $("#account_check").html("邮箱格式不正确");
        else{
        	//重置密码  判断是否存在该邮箱
        	var url = "checkEmailExist.do";
	        var args = {
	            "mail":mail
	        }
	        console.log(mail);
	        $.post(url,args,function(data){
	            if(data == "0"){//不能找到该用户
	                $("#account_check").html("该邮箱还未注册");
	            }else if(data == 1){
	                //找到该用户
	                $("#account_check").html("验证码已经发送，请注意查收");
	                success = "0";
	                //一分钟倒计时
	                countDown();
	                //发送邮件
	                url = "yzm.do";
	                $.post(url,args,function(data){               
	                })
	            }
	       })
            
        }
         
    });

   //发送了验证码开始倒计时
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
    // var verifyCode = new GVerify("v_container");
    // $("#reset_pwd_btn").click(function(){
    //     var res = verifyCode.validate(document.getElementById("code_input").value);
    //     if(res){
    //         alert("验证正确");
    //     }else{
    //         alert("验证码错误");
    //     }
    // })



