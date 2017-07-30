
var name, sex, mail, pro;
$(".nav-tabs li").click(function() {


    $(".nav-tabs li").attr("class", "");
    $(this).attr("class", "active");
    var id = "." + $(this).attr("id");
    if (id == ".editInfo") {
        $(".editInfo .base ul li .name input").val(name);
        $(".editInfo .base ul li .sex select").val(sex);
        $(".editInfo .base ul li .mail").text(mail);
        $(".editInfo .base ul li .pro select").val(pro);
    }
    $(".showInfo").css("display", "none");
    $(id).css("display", "block");
})

window.onload = a();

function a() {
    name = $(".baseInfo .base ul li .name").text();
    sex = $(".baseInfo .base ul li .sex").text();
    mail = $(".baseInfo .base ul li .mail").text();
    pro = $(".baseInfo .base ul li .pro").text();
}





//图片格式

$('.img_show').each(function() {
    var $this = $(this),
        btn = $this.find('.upfile'),
        img = $this.find('img');
    btn.on('change', function() {
        var file = $(this)[0].files[0],
            imgSrc = $(this)[0].value,
            url = URL.createObjectURL(file);
        if (!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
            alert("请上传jpg或png格式的图片！");
            return false;
        } else {
            img.attr('src', url);
            img.css({ 'opacity': '1' });
        }
    });
});

//密码修改

//1.旧密码验证
$(".next").on("click",function(){
    var oldPwd = $(".oldPwd").val();
    if(oldPwd == ""||oldPwd == null)
        alert("密码不能为空");
    else{
        var url = "login.do";
        var args = {
            "mail":mail,
            "password":oldPwd,
            "boss":0
        }
       $.post(url,args,function(data){
            //成功找到用户
        	if(data == 1){
    			$("#myModal").modal('hide');
                $("#editModal").modal('show');
        	}else if(data == 0){
        		//密码和账号不匹配
                alert("密码错误,请重新输入");
        		
        	}            
            
       })
   }
})

$(".newPwd2").change(function(){
    var newPwd1 = $(".newPwd1").val();
    var newPwd2 = $(".newPwd2").val();
    var words = "";
    if(newPwd1 !=null && newPwd1 !="")
        if (newPwd1 == oldPwd) 
            words = "新旧密码不能一致";
    $(".newPwdSpan").html(words);
    
})
//密码修改
$(".pwdButton").click(function(){
    var newPwd1 = $(".newPwd1").val();
    var newPwd2 = $(".newPwd2").val();
    var oldPwd = $(".oldPwd").val();
    var words="";
    if(newPwd1.length == 0||newPwd2.length == 0) {
        words = "密码不能为空";
    }else if(newPwd1 == oldPwd){
       words = "新旧密码不能一致";
    }else if (newPwd1 != newPwd2) {
        words = "两次密码输入不一致";
    }else if (newPwd1.length < 6) {
        words = "密码至少含有6个字符";
    }else{
        var url = "editPwd.do";
        var args = {
            "mail":mail,
            "password": newPwd1,
            "boss":0
        }
       $.post(url,args,function(data){
        	if(data == 1){
        		alert("修改成功");
                setTimeout("history.go(0)" ,500);
        	}else if(data == 1){
        		$(".newPwdSpan").html("修改失败");
        	}
        })
    }
     $(".newPwdSpan").html(words);
})

//基本信息修改
$(".baseButton").click(function(){
    name = $(".editInfo .base ul li .name input").val();
    sex = $(".editInfo .base ul li .sex select").val();
    pro = $(".editInfo .base ul li .pro select").val();
    var words = "";
    if(name.length == 0) {
        words = "姓名不能为空";
    }else{
        var url = "editInfo.do";
        var args = {
            "mail":mail,
            "name": name,
            "pro":pro,
            "sex":sex,
            "boss":0
        }
        $.post(url,args,function(data){
        	if(data == 1){
        		words = "修改成功";
        		window,location.href="student-info.html";
        	}
        	else if(data == 0){
        		words = "修改失败";
        	}
        })
    }
    $(".ccc").html(words);
})


//图片修改

 $("#upload").on('click', function() {  
        $('#fileToUpload').click();  
    }); 
 $('#fileToUpload').on('change', function() {  
    alert(1);
        $.ajaxFileUpload({  
            url:'',  
            secureuri:false,  
            fileElementId:'fileToUpload',//file标签的id  
            dataType: 'json',//返回数据的类型  
            data:{name:'logan'},//一同上传的数据  
            success: function (data, status) {  
                //把图片替换  
                var obj = jQuery.parseJSON(data);  
                $("#upload").attr("src", "../image/"+obj.fileName);  
      
                if(typeof(data.error) != 'undefined') {  
                    if(data.error != '') {  
                        alert(data.error);  
                    } else {  
                        alert(data.msg);  
                    }  
                }  
            },  
            error: function (data, status, e) {  
                alert(e);  
            }  
        });  
    });  
$(".release-content .glyphicon-remove").click(function() {
    $(".release").css("-webkit-animation-name","bounceoutL");
    $(".release").css("-webkit-animation-duration","1s");
    $(".release").css("animation-fill-mode","forwards");
});

$(".apply").click(function() {
    /* Act on the event */
    if ($(".submits").css("display")=="block") {
        alert("信息已发送，请勿重复发送");
    }else{
        $(".alerts").css("display","block");
        $(".mask").css("display","block");
    }
});
$(".btn-warning").click(function() {
    /* Act on the event */
    $(".alerts").css("display","none");
    $(".mask").css("display","none");
});
$(".btn-info").click(function() {
    /* Act on the event */
    $(".submits").css("display","block");
    $(".alerts").css("display","none");
    $(".mask").css("display","none");
});