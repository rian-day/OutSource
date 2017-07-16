// var length = "";
// var name, sex, mail;
// var info = new Array();
// $("a").click(function() {
//     var lo = $(this).attr("class");
//     if (lo == 'editMark') {
//         //进行修改操作(基本信息)
//         info[0] = $(".name").text();
//         info[1] = $(".sex").text();
//         info[2] = $(".mail").text();
//         info[3] = $(".pro").text();
//         var i = 0;
//         $(".tableEbi td input").each(function() {
//             $(this).val(info[i]);
//             i++;
//         });
//         //显示修改界面(基本信息)
//         $(".studentInfo").fadeOut();
//         setTimeout('$(".studentEdit").fadeIn();', 650)
//     }else if(lo == "editPwd"){
//         //进行修改操作(密码)       
//         info[0] = $(".mail").text();
//         $(".tableEpI tr td input[type='text']").each(function() {
//             $(this).val(info[0]);
//         });
//         //显示修改界面(密码)
//         $(".studentInfo").fadeOut();
//         setTimeout('$(".editPassword").fadeIn();', 650)
//     } 
//     else {
//         $(".editPassword").fadeOut();
//         $(".studentEdit").fadeOut();
//         setTimeout('$(".studentInfo").fadeIn();', 650)
//     }
// })
// $(".jobSelect").mouseenter(function() {
//     $(this).css({
//         "background-color": "#DDDDDD"
//     })
// })
// $(".jobSelect").mouseout(function() {
//     $(this).css({
//         "background-color": "#FFFFFF"
//     })
// })
// $(".jobSelect").click(function() {
//     var info = ($(this).text());
//     if(info == '女'||info == '男')
//         $("#sexShow").val($(this).text());
//     else
//         $("#jobShow").val($(this).text());
// })

// $("#PwdEdit").click(function(){
//     var password1 = $(".password1").val();
//     var password2 = $(".password2").val();
//     if(password1 != password2){
//        $(".pwdAlert").fadeIn();
//        return false;
//     }
// })




// $(".close").click(function(){
//     $(".pwdAlert").fadeOut();
// })
var name,sex,mail,pro;
$(".nav-tabs li").click(function(){


    $(".nav-tabs li").attr("class","");
    $(this).attr("class","active");
    var id = "."+$(this).attr("id");
    if(id == ".editInfo"){
        $(".editInfo .base ul li .name input").val(name);
        $(".editInfo .base ul li .sex select").val(sex);
        $(".editInfo .base ul li .mail").text(mail);
        $(".editInfo .base ul li .pro select").val(pro);
    }
    $(".showInfo").css("display","none");
    $(id).css("display","block");
})

window.onload=a;

function a(){
    name = $(".baseInfo .base ul li .name").text();
    sex = $(".baseInfo .base ul li .sex").text();
    mail = $(".baseInfo .base ul li .mail").text();
    pro = $(".baseInfo .base ul li .pro").text();
}





 

  $('.img_show').each(function(){
   var $this = $(this),
    btn = $this.find('.upfile'),
    img = $this.find('img');
   btn.on('change',function(){
    var file = $(this)[0].files[0],
     imgSrc = $(this)[0].value,
     url = URL.createObjectURL(file);
    if (!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)){
     alert("请上传jpg或png格式的图片！");
     return false;
    }else{
     img.attr('src',url);
     img.css({'opacity':'1'});
    }
   });
  });

 