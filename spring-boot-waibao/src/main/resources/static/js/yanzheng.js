var countdown = 60;

function settime(obj) {
	var al = "";
	if ($(".Email").val()==""||$(".Email").val()==null) {
		al = "邮箱不能为空";
	}
	else if (!$(".Email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
		al = "邮箱格式不正确";
	}
	else{
		var mail = $(".Email").val();
		var url = "";
		args = {
			"mail":mail
		}
		$.post(url,args,function(data){});
		al = "验证码已发送，请耐心等待"
	    if (countdown == 0) {
	        obj.removeAttribute("disabled");
	        obj.value = "重新发送";
	        countdown = 60;
	        return;
	    } else {
	        obj.setAttribute("disabled", true);
	        obj.value = "重新发送(" + countdown + ")";
	        countdown--;
	    }
	    setTimeout(function() {
	        settime(obj)
	    }, 1000)
	}
	$(".prompt2").html(al);
}




