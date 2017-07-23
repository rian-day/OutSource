$(document).ready(function() {
    var timuindex = 0;
    var settimuindex = 0;
	$(window).bind("scroll", function () {  
        var sTop = $(window).scrollTop();  
        var sTop = parseInt(sTop);  
        if (sTop >= 250) {
        	$(".login-btn").css({
        		'width': '70px',
        		'margin-left': '120px'
        	});
        	$(".login-font").hide();
        	$(".totop-img").show();
        	$(".search-info span:nth-child(2)").css({
        		'color': 'black'
        	});
        }else {
        	$(".login-btn").css({
        		'width': '190px',
        		'margin-left': '0px'
        	});
		    $(".totop-img").hide();
    		$(".login-font").show();
    		$(".search-info span:nth-child(2)").css({
        		'color': '#f4f7f6'
        	});
        }   
    }); 
    $(".search-info").click(function() {
    	$(".overlay-content").css({
    		'z-index': '50000',
    		'opacity': '1',
    	});
    	$(".box-right").css({
    		'display': 'none'
    	});
    	$(".box-right-search").css({
    		'display': 'flex'
    	});
    });
    $(".box-close,.overlay-content,.pull-right").click(function() {
    	$(".overlay-content").css({
    		'opacity': '0'
    	});
    	$(".box-right").css({
			'display': 'flex'
		});
		$(".box-right-search").css({
			'display': 'none'
		});
		$(".move-right").css({
    		'-webkit-transform': 'none',
    		'transform': 'none',
    		'position': 'relative',
    	});
    	$(".menu").css({
    		'-webkit-transform': 'translateX(-320px)',
    		'transform': 'translateX(-320px)'
    	});
    	setTimeout(function(){
			$(".overlay-content").css({
	    		'z-index': '-1'
	    	});
    	},300);
    });
    $(".totop-img").click(function() {
    	$('html,body').animate({scrollTop: 0}, 300);
    });
    $(".to-dropdown").click(function() {
    	if ($(".menu-dropdown").css('opacity')==1){
			$(".menu-dropdown").css({
	    		'opacity': '0',
	    		'visibility': 'hidden',
	    		'top': '0px',
	    	});
    	}else{
    		$(".menu-dropdown").css({
	    		'opacity': '1',
	    		'visibility': 'visible',
	    		'top': '35px',
	    	});
    	}
    });
    $(".menu-dropdown a").click(function() {
    	$(".search-type").text($(this).text());
    });
    $(".box-left").click(function() {
    	$(".overlay-content").css({
    		'z-index': '85000',
    		'opacity': '1',
    	});
    	$(".move-right").css({
    		'-webkit-transform': 'translateX(320px)',
    		'transform': 'translateX(320px)',
    		'position': 'fixed',
    	});
    	$(".menu").css({
    		'-webkit-transform': 'translateX(-0px)',
    		'transform': 'translateX(-0px)'
    	});
    });
    $(".second-menu div").click(function() {
		var tid = $(this).attr('class');
		tid = '.second-menu-' + tid + ' li';
		var theight = $(tid).css('height');
		if(theight=='70px'){
			$(".second-menu li").css({
				'height': '0px',
				'opacity': '0'
			});
		}else{
			$(".second-menu li").css({
				'height': '0px',
				'opacity': '0'
			});
			$(tid).css({
				'height': '70px',
				'opacity': '1'
			});
		}
    }); 
    $(".title-select").change(  
        function() {   
            var a = '.box-title' + $(".title-select").val();  
            $(".box-title > div").hide();
            $(a).show(); 
        }  
    ); 
    $("div[id$='timu'],div[id$='daan1'],div[id$='daan2'],div[id$='daan3'],div[id$='daan4'],div[id$='daan5'],div[id$='daan6'],div[id$='jiexi']").click(function(){
		$("div[id$='timu-1'],div[id$='daan1-1'],div[id$='daan2-1'],div[id$='daan3-1'],div[id$='daan4-1'],div[id$='daan5-1'],div[id$='daan6-1'],div[id$='jiexi-1']").css({
				'opacity': '0',
				'height': '0px',
			});
		$("div[id$='timu'],div[id$='daan1'],div[id$='daan2'],div[id$='daan3'],div[id$='daan4'],div[id$='daan5'],div[id$='daan6'],div[id$='jiexi']").height(40);
		var tid = "#" + $(this).attr('id') + "-1";
		$(tid).css({
				'opacity': '1',
				'height': '30px',
			});
		$(this).height(150);
    });
    $(".danxuan-add-daan").click(function(){
        if ($(".box-title1 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title1 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title1 #behide4").attr('class')=='keyList behide4') {
                    if ($(".box-title1 #behide3").attr('class')=='keyList behide3') {
                        $(".box-title1 #behide3").attr('class','keyList');
                    }else{
                        $(".box-title1 #behide4").attr('class','keyList');
                    }
                }else{
                    $(".box-title1 #behide5").attr('class','keyList');
                }
            }else{
                $(".box-title1 #behide6").attr('class','keyList');
            }
        }else{
            alert('只能添加六个选项');
        }
    });
    $(".duoxuan-add-daan").click(function(){
        if ($(".box-title2 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title2 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title2 #behide4").attr('class')=='keyList behide4') {
                    if ($(".box-title2 #behide3").attr('class')=='keyList behide3') {
                        $(".box-title2 #behide3").attr('class','keyList');
                    }else{
                        $(".box-title2 #behide4").attr('class','keyList');
                    }
                }else{
                    $(".box-title2 #behide5").attr('class','keyList');
                }
            }else{
                $(".box-title2 #behide6").attr('class','keyList');
            }
        }else{
            alert('只能添加六个选项');
        }
    });
    $(".tiankong-add-daan").click(function(){
        if ($(".box-title3 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title3 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title3 #behide4").attr('class')=='keyList behide4') {
                    if ($(".box-title3 #behide3").attr('class')=='keyList behide3') {
                        if ($(".box-title3 #behide2").attr('class')=='keyList behide2') {
                            $(".box-title3 #behide2").attr('class','keyList');
                        }else{
                            $(".box-title3 #behide3").attr('class','keyList');
                        }
                    }else{
                        $(".box-title3 #behide4").attr('class','keyList');
                    }
                }else{
                    $(".box-title3 #behide5").attr('class','keyList');
                }
            }else{
                $(".box-title3 #behide6").attr('class','keyList');
            }
        }else{
            alert('只能添加六个选项');
        }
    });
    $(".box-title1 .glyphicon").click(function(){
        if ($(".box-title1 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title1 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title1 #behide4").attr('class')=='keyList behide4') {
                    $(".box-title1 #behide3").attr('class','keyList behide3');
                    $(".box-title1 #behide3 p").text("");
                }else{
                    $(".box-title1 #behide4").attr('class','keyList behide4');
                    $(".box-title1 #behide4 p").text("");
                }
            }else{
                $(".box-title1 #behide5").attr('class','keyList behide5');
                $(".box-title1 #behide5 p").text("");
            }
        }else{
            $(".box-title1 #behide6").attr('class','keyList behide6');
            $(".box-title1 #behide6 p").text("");
        }
    });
    $(".box-title2 .glyphicon").click(function(){
        if ($(".box-title2 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title2 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title2 #behide4").attr('class')=='keyList behide4') {
                    $(".box-title2 #behide3").attr('class','keyList behide3');
                    $(".box-title2 #behide3 p").text("");
                }else{
                    $(".box-title2 #behide4").attr('class','keyList behide4');
                    $(".box-title2 #behide4 p").text("");
                }
            }else{
                $(".box-title2 #behide5").attr('class','keyList behide5');
                $(".box-title2 #behide5 p").text("");
            }
        }else{
            $(".box-title2 #behide6").attr('class','keyList behide6');
            $(".box-title2 #behide6 p").text("");
        }
    });
    $(".box-title3 .glyphicon").click(function(){
        if ($(".box-title3 #behide6").attr('class')=='keyList behide6') {
            if ($(".box-title3 #behide5").attr('class')=='keyList behide5') {
                if ($(".box-title3 #behide4").attr('class')=='keyList behide4') {
                    if ($(".box-title3 #behide3").attr('class')=='keyList behide3') {
                        $(".box-title3 #behide2").attr('class','keyList behide2');
                        $(".box-title3 #behide2 p").text("");
                    }else{
                        $(".box-title3 #behide3").attr('class','keyList behide3');
                        $(".box-title3 #behide3 p").text("");
                    }
                }else{
                    $(".box-title3 #behide4").attr('class','keyList behide4');
                    $(".box-title3 #behide4 p").text("");
                }
            }else{
                $(".box-title3 #behide5").attr('class','keyList behide5');
                $(".box-title3 #behide5 p").text("");
            }
        }else{
            $(".box-title3 #behide6").attr('class','keyList behide6');
            $(".box-title3 #behide6 p").text("");
        }
    });
    $(".add-fast-access").click(function() {
        $(".black-out-curtain").css({
            'opacity': '1',
            'z-index': '85000'
        });
    });

    /*$(".filter").change(function(){
        $.ajax({
            type: "GET",
            url: "test.json",
            data: {username:$("#username").val(), content:$("#content").val()},
            dataType: "json",
            success: function(data){
                $('#resText').empty();   //清空resText里面的所有内容
                var html = ''; 
                $.each(data, function(commentIndex, comment){
                    html += '<div class="comment"><h6>' + comment['username']
                            ':</h6><p class="para"' + comment['content']
                            + '</p></div>';
                });
                $('#resText').html(html);
            }
        });
    });*/
    $(document).on("click",".select-timu",function(){
        var zhiye = $(".pro-select").val();
        if (zhiye=="0") {
            alert('请选择职业!');
        }else{
            $(".add-timu-black").css({
                'z-index': '85000',
                'opacity': '1'
            });
        }
        timuindex = $(this).parent().parent().index();
    });
    $(document).on("click",".insert-timu",function(){
        $(".insert-timu-black").css({
            'z-index': '85000',
            'opacity': '1'
        });
        settimuindex = $(this).parent().parent().index();
    });
    $(document).on("click",".add-button",function(){
        var thetext = $(this).parent().parent().find("td:eq(1)").text();
        $("#handle-1").find('li:eq('+timuindex+')').find('div:eq(1)').text(thetext);
        $(".add-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });
    /*$(".select-timu").click(function() {
        $(".add-timu-black").css({
            'z-index': '85000',
            'opacity': '1'
        });
    });
    $(".insert-timu").click(function() {
        $(".insert-timu-black").css({
            'z-index': '85000',
            'opacity': '1'
        });
    });*/
    $(".add-timu-black .glyphicon-remove").click(function() {
        $(".add-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });
    $(".insert-timu-black .add-title > .glyphicon").click(function() {
        $(".insert-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
        $(".w-e-text p").text('');
    });
    $(".add-project").click(function() {
        $('<li><div class="drag-handle">&#9776;</div><div class="handle-timu"></div><div class="timu-info"><span class="glyphicon glyphicon-remove" title="删除题目"></span>题目ID:<input type="text" class="timu-id" disabled="true"><br>题目分值：<input type="text"/>分<br>题目类型：<select class="title-select" name="">  <option class="title1" value="1">单选</option> <option class="title2" value="2">多选</option> <option class="title3" value="3">填空</option> <option class="title4" value="4">判断</option> </select><br/><div class="select-timu">选择题目</div><div class="insert-timu">录入题目</div></div></li>').insertBefore(".tp-button");
    });
    $(document).on("click",".timu-info .glyphicon",function(){
        $(this).parent().parent().remove();
    });






    var btnarr=$('pro-revise ul');
    $(".pro-revise ul li:eq(0) input:eq(1)").click(function() {
        $(".pro-name ul li:eq(0)").text($(".pro-revise ul li:eq(0) input:eq(0)").val());
    });
    $(".pro-revise ul li:eq(1) input:eq(1)").click(function() {
        $(".pro-name ul li:eq(1)").text($(".pro-revise ul li:eq(1) input:eq(0)").val());
    });
    $(".add-pro input:eq(0)").click(function() {
        snum=$('.pro-name li').size()+1;
    //  console.log(snum);
        var s1="<li>默认职业</li>";
        $(".pro-name ul li:last").after(s1);
        var s2="<li ><input type='text' name='' class='zhiye' style='margin-left:10.7%;'><input type='submit' value='确认更改' class='btn btn-info prdemo' style='margin-left:2%;'></li>"
        $(".pro-revise ul li:last").after(s2);
       // btnarr=$('pro-revise ul');
    });
    // var i=$(".pro-name li").length;
    // for (var s=0;s<i;s++) {
    //  alert(1);
    //  $(".pro-revise ul li:eq(s) input:eq(1)").click(function() {
    //  $(".pro-name ul li:eq(s)").text($(".pro-revise ul li:eq(s) input:eq(0)").val());
    // });
    // }
    $(document).on("click",".prdemo",function() {
        console.log(btnarr);
        var snum=$(this).parent().index();
        var temp=$(this).prev().val();
        $('.pro-name ul li').eq(snum).text(temp);
    });

    /*click(function(event) {
        var title
        var option{
            xuanxiangmiang:AB,
            content:jkjk
        }var option{
            xuanxiangmiang:AB,
            content:jkjk
        }var option{
            xuanxiangmiang:AB,
            content:jkjk
        }
        var list [option,option,option]
        var timu{
            title:title,
            options:list,
            answer:,
            'xiexi':'xiexi'
        }
    });*/
    $(".tijiao-danxuan").click(function() {

        var zhiye = $(".zhiye option:selected").val();         //顾名思义 这是职业
        if (zhiye=="0") {
            alert('请选择职业!');
        }else{
            var content = $("#danxuan-timu div p").text() + 
                            "<br/>A:" + $("#danxuan-daan1 div p").text() +
                            "<br/>B:" + $("#danxuan-daan2 div p").text();
            if ($(".box-title1").children('.keyList:eq(2)').attr('class')!='keyList behide3') {
                content = content +  "<br/>C:" + $("#danxuan-daan3 div p").text();
                if ($(".box-title1").children('.keyList:eq(3)').attr('class')!='keyList behide4') {
                    content = content +  "<br/>D:" + $("#danxuan-daan4 div p").text();
                    if ($(".box-title1").children('.keyList:eq(4)').attr('class')!='keyList behide5') {
                        content = content +  "<br/>E:" + $("#danxuan-daan5 div p").text();
                        if ($(".box-title1").children('.keyList:eq(5)').attr('class')!='keyList behide6') {
                            content = content +  "<br/>F:" + $("#danxuan-daan6 div p").text();
                        }
                    }
                }
            }
            /*var title = $("#danxuan-timu div p").text();        //题目
            var option1={
                'xuanxiangming' : 'A',
                'content' : $("#danxuan-daan1 div p").text()
            }
            var option2={
                'xuanxiangming' : 'B',
                'content' : $("#danxuan-daan2 div p").text()
            }
            var option3={
                'xuanxiangming' : 'C',
                'content' : $("#danxuan-daan3 div p").text()
            }
            var option4={
                'xuanxiangming' : 'D',
                'content' : $("#danxuan-daan4 div p").text()
            }
            var option5={
                'xuanxiangming' : 'E',
                'content' : $("#danxuan-daan5 div p").text()
            }
            var option6={
                'xuanxiangming' : 'F',
                'content' : $("#danxuan-daan6 div p").text()
            }
            var options = [option1,option2,option3,option4,option5,option6];        //选项*/
            var obj = $(".box-title1 input[type='radio']");
            var answer=[]; 
            $(obj).each(function(index, el) {
                if(obj[index].checked) answer.push($(this).val());
            });
            /*arr.push('a');*/
            /*answer = $(".box-title1 input[type='radio']:checked").val();        //答案*/
            var analysis = $(".danxuan-jiexi").text();      //解析
            /*var danxuantimu = {
                'content' : content,      //content内容
                'type' : 1,     //type题目类型
                'realAnswer' : answer,       //realAnswer正确答案
                'tip' : analysis,      //tip注释
                'professionId' : zhiye        //professionId职业ID
            }*/
            $.ajax({
                type: "POST",
                url: "add-subject.do",
                data: {
                    'content' : content,        //content内容
                    'type' : 1,                 //type题目类型
                    'realAnswer' : answer,      //realAnswer正确答案
                    'tip' : analysis,           //tip注释
                    'professionId' : zhiye      //professionId职业ID
                },
                dataType: "json",
                success: function(data){
                    //  成功id 不成功0
                    if (data==0) {
                        alert("上传失败");
                    }else{
                        alert("上传成功");
                        $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
                        $("#handle-1 li:eq("+settimuindex+") .timu-id").val(data);
                        $(".insert-timu-black").css({
                            'z-index': '-1',
                            'opacity': '0'
                        });
                    }
                }
            });
        }
    });
    $(".tijiao-duoxuan").click(function() {
        var zhiye = $(".zhiye option:selected").val();
        if (zhiye=="0") {
            alert('请选择职业!');
        }else{
            var content = $("#duoxuan-timu div p").text() + 
                            "<br/>A:" + $("#duoxuan-daan1 div p").text() +
                            "<br/>B:" + $("#duoxuan-daan2 div p").text();
            if ($(".box-title2").children('.keyList:eq(2)').attr('class')!='keyList behide3') {
                content = content +  "<br/>C:" + $("#duoxuan-daan3 div p").text();
                if ($(".box-title2").children('.keyList:eq(3)').attr('class')!='keyList behide4') {
                    content = content +  "<br/>D:" + $("#duoxuan-daan4 div p").text();
                    if ($(".box-title2").children('.keyList:eq(4)').attr('class')!='keyList behide5') {
                        content = content +  "<br/>E:" + $("#duoxuan-daan5 div p").text();
                        if ($(".box-title2").children('.keyList:eq(5)').attr('class')!='keyList behide6') {
                            content = content +  "<br/>F:" + $("#duoxuan-daan6 div p").text();
                        }
                    }
                }
            }
            /*var title = $("#duoxuan-timu div p").text();
            var option1={
                'xuanxiangming' : 'A',
                'content' : $("#duoxuan-daan1 div p").text()
            }
            var option2={
                'xuanxiangming' : 'B',
                'content' : $("#duoxuan-daan2 div p").text()
            }
            var option3={
                'xuanxiangming' : 'C',
                'content' : $("#duoxuan-daan3 div p").text()
            }
            var option4={
                'xuanxiangming' : 'D',
                'content' : $("#duoxuan-daan4 div p").text()
            }
            var option5={
                'xuanxiangming' : 'E',
                'content' : $("#duoxuan-daan5 div p").text()
            }
            var option6={
                'xuanxiangming' : 'F',
                'content' : $("#duoxuan-daan6 div p").text()
            }
            var options = [option1,option2,option3,option4,option5,option6];*/
            var obj = $(".box-title2 input[type='checkbox']");
            var answer=[]; 
            $(obj).each(function(index, el) {
                if(obj[index].checked) answer.push($(this).val());
            });
            var analysis = $(".duoxuan-jiexi").text();
            /*var duoxuantimu = {
                'pro' : zhiye,
                'title' : title,
                'options' : options,
                'answer' : answer,
                'analysis' : analysis
            }
            $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
            $(".insert-timu-black").css({
                'z-index': '-1',
                'opacity': '0'
            });*/
            $.ajax({
                type: "POST",
                url: "add-subject.do",
                data: {
                    'content' : content,        
                    'type' : 2,                 
                    'realAnswer' : answer,      
                    'tip' : analysis,           
                    'professionId' : zhiye      
                },
                dataType: "json",
                success: function(data){
                    if (data==0) {
                        alert("上传失败");
                    }else{
                        alert("上传成功");
                        $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
                        $("#handle-1 li:eq("+settimuindex+") .timu-id").val(data);
                        $(".insert-timu-black").css({
                            'z-index': '-1',
                            'opacity': '0'
                        });
                    }
                }
            });
        }
    });
    $(".tijiao-tiankong").click(function() {
        var zhiye = $(".zhiye option:selected").val();
        if (zhiye=="0") {
            alert('请选择职业!');
        }else{
            var content = $("#tiankong-timu div p").text();
            /*var option1={
                'xuanxiangming' : '1',
                'content' : $("#tiankong-daan1 div p").text()
            }
            var option2={
                'xuanxiangming' : '2',
                'content' : $("#tiankong-daan2 div p").text()
            }
            var option3={
                'xuanxiangming' : '3',
                'content' : $("#tiankong-daan3 div p").text()
            }
            var option4={
                'xuanxiangming' : '4',
                'content' : $("#tiankong-daan4 div p").text()
            }
            var option5={
                'xuanxiangming' : '5',
                'content' : $("#tiankong-daan5 div p").text()
            }
            var option6={
                'xuanxiangming' : '6',
                'content' : $("#tiankong-daan6 div p").text()
            }
            var answer = [option1,option2,option3,option4,option5,option6];*/
            var answer = [];
            answer.push($("#tiankong-daan1 div p").text());

            if ($(".box-title3").children('.keyList:eq(0)').attr('class')!='keyList behide2') {
                answer.push($("#tiankong-daan2 div p").text());
                if ($(".box-title3").children('.keyList:eq(1)').attr('class')!='keyList behide3') {
                    answer.push($("#tiankong-daan3 div p").text());
                    if ($(".box-title3").children('.keyList:eq(2)').attr('class')!='keyList behide4') {
                        answer.push($("#tiankong-daan4 div p").text());
                        if ($(".box-title3").children('.keyList:eq(3)').attr('class')!='keyList behide5') {
                            answer.push($("#tiankong-daan5 div p").text());
                            if ($(".box-title3").children('.keyList:eq(4)').attr('class')!='keyList behide6') {
                                answer.push($("#tiankong-daan6 div p").text());
                            }
                        }
                    }
                }
            }
            var analysis = $(".tiankong-jiexi").text();
            /*var tiankongtimu = {
                'pro' : zhiye,
                'title' : title,
                'answer' : answer,
                'analysis' : analysis
            }
            $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
            $(".insert-timu-black").css({
                'z-index': '-1',
                'opacity': '0'
            });*/
            $.ajax({
                type: "POST",
                url: "add-subject.do",
                data: {
                    'content' : content,        
                    'type' : 3,                 
                    'realAnswer' : answer,      
                    'tip' : analysis,           
                    'professionId' : zhiye      
                },
                dataType: "json",
                success: function(data){
                    if (data==0) {
                        alert("上传失败");
                    }else{
                        alert("上传成功");
                        $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
                        $("#handle-1 li:eq("+settimuindex+") .timu-id").val(data);
                        $(".insert-timu-black").css({
                            'z-index': '-1',
                            'opacity': '0'
                        });
                    }
                }
            });
        }
    });
    $(".tijiao-panduan").click(function() {
        var zhiye = $(".zhiye option:selected").val();
        if (zhiye=="0") {
            alert('请选择职业!');
        }else{
            var content = $("#panduan-timu div p").text();
            var answer = [];
            answer.push($(".box-title4 input[type='radio']:checked").val());
            alert(answer);
            var analysis = $("#panduan-jiexi div p").text();
            /*var panduantimu = {
                'pro' : zhiye,
                'title' : title,
                'answer' : answer,
                'analysis' : analysis
            }
            $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
            $(".insert-timu-black").css({
                'z-index': '-1',
                'opacity': '0'
            });*/
            $.ajax({
                type: "POST",
                url: "add-subject.do",
                data: {
                    'content' : content,        
                    'type' : 4,                 
                    'realAnswer' : answer,      
                    'tip' : analysis,           
                    'professionId' : zhiye      
                },
                dataType: "json",
                success: function(data){
                    if (data==0) {
                        alert("上传失败");
                    }else{
                        alert("上传成功");
                        $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(content);
                        $("#handle-1 li:eq("+settimuindex+") .timu-id").val(data);
                        $(".insert-timu-black").css({
                            'z-index': '-1',
                            'opacity': '0'
                        });
                    }
                }
            });
        }
    });
    

/*设置职业*/
    $(".submitdemo").click(function() {
        var zhiye = [];
        $(".pro-name li").each(function(index, el) {
            zhiye[index] = $(this).text();
        });
        $.ajax({
            type: "POST",
            url: "set-pro-list.do",
            data: {
                'zhiye' : zhiye
            },
            dataType: "json",
            success: function(data){
                if (data==1) {
                    alert("修改成功");
                }else{
                    alert("修改失败");
                }
            }
        });
    });


/*设置快速访问列表*/
    $(".set-index-list").click(function(event) {
        var obj = $(".index-show-list input[type=checkbox]");
        var indexList = [];
        $(obj).each(function(index, el) {
            if (obj[index].checked) {
                indexList[index] = 1;
            }else{
                indexList[index] = 0;
            }
        });
        $.ajax({
            type: "POST",
            url: "set-index-list.do",
            data: {
                'indexList' : indexList
            },
            dataType: "json",
            success: function(data){
                if (data==1) {
                    alert("修改成功");
                }else{
                    alert("修改失败");
                }
            }
        });
    });



    
    $(".sub-cancel").click(function() {
        $(".add-suiji-black").css({
            'z-index': '-1',
            'opacity': '0',
        });
    });
    $(".creat-suijitp").click(function() {
        var tpname = $(".tp-head-info input[type=text]").val();
        var tppro = $(".tp-head-info .pro-select option:selected").val();
        if (tpname=="") {
            alert('请输入试卷名！');
        }else if(tppro=='0'){
            alert('请选择职业！');
        }else{
            $(".add-suiji-black").css({
                'z-index': '85000',
                'opacity': '1',
            });
        }
    });
    /*创建随机题目*/
    $(".sub-suiji-project").click(function() {
        var tpname = $(".tp-head-info input[type=text]").val();    //试卷名称
        var tppro = $(".tp-head-info .pro-select option:selected").val();       //职业
        /*var suijitp = {
            'tpname' : tpname,      
            'tppro' : tppro
        };*/
        var type = [];
        var num = [];
        var mark = [];
        $("#handle-2 li").each(function(index, el) {
            type.pushi($(el).children('.handle-timu').children('input[type=hidden]').val());     //类型
            num.push($(el).children('.handle-timu').children('input[type=text]:eq(0)').val());      //数量
            mark.push($(el).children('.handle-timu').children('input[type=text]:eq(1)').val());     //分数
            /*var suijitimu = {
                'type' : type,
                'num' : num,
                'mark' : mark,
            };
            suijitp[index] = suijitimu;*/
        });
        $.ajax({
            type: "POST",
            url: "creat-suijitp.do",
            data: {
                'tpname' : tpname,
                'professionId' : tppro,
                'type' : type,
                'num' : num,
                'mark' : mark,
            },
            dataType: "json",
            success: function(data){
                if (data==1) {
                    alert("提交成功");
                }else{
                    alert("提交失败");
                }
            }
        });
    });
    /*提交试卷信息*/
    $(".sub-project").click(function() {
        /*var tp = [];*/
        var name = $(".tp-head-info input[type=text]").val();
        var pro = $(".tp-head-info .pro-select option:selected").val();
        var hrd = $(".tp-head-info .difficulty-select option:selected").val();
        if (name=="") {
            alert('请输入试卷名！');
        }else if(pro=='0'){
            alert('请选择职业！');
        }else if(hrd=='0'){
            alert('请选择难度！');
        }else{
            /*tp = {
                'name' : name,
                'pro' : pro,
                'hrd' : hrd
            }*/
            var timuid = [];
            $("#handle-1 li").each(function(index, el) {        //index是从零开始的
                timuid.push((this).children(".timu-info").children(".timu-id").val());
                /*var timu = {
                }
                tp[index] = timu;*/
            });
            $.ajax({
                type: "POST",
                url: "sendtp.do",
                data: {
                    'name' : name,      //名称
                    'pro' : pro,        //职业
                    'hrd' : hrd,         //难度
                    'timuid' : timuid,      //题目id(数组)
                },
                dataType: "json",
                success: function(data){
                    if (data==1) {
                        alert("修改成功");
                    }else{
                        alert("修改失败");
                    }
                }
            });
        }
    });

    /*$("#tijiao-danxuan").click(function() {
        var pushtimu = "";
        pushitimu = $("#danxuan-timu div p").text() + "<br/>";
        pushitimu = pushitimu + "A:" + $("#danxuan-daan1 div p").text() + "<br/>" +
                                "B:" + $("#danxuan-daan2 div p").text() + "<br/>";
        if ($(".box-title1").children('.keyList:eq(2)').attr('class')=='keyList behide3') {
            pushitimu = pushitimu + "C:" + $("#danxuan-daan3 div p").text() + "<br/>";
            if ($(".box-title1").children('.keyList:eq(3)').attr('class')=='keyList behide4') {
                pushitimu = pushitimu + "D:" + $("#danxuan-daan4 div p").text() + "<br/>";
                if ($(".box-title1").children('.keyList:eq(4)').attr('class')=='keyList behide5') {
                    pushitimu = pushitimu + "E:" + $("#danxuan-daan5 div p").text() + "<br/>";
                    if ($(".box-title1").children('.keyList:eq(5)').attr('class')=='keyList behide6') {
                        pushitimu = pushitimu + "F:" + $("#danxuan-daan6 div p").text() + "<br/>";
                    }
                }
            }
        }
        $("#handle-1 li:eq("+settimuindex+") .handle-timu").html(pushitimu);
        $(".insert-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });
    $("#tijiao-duoxuan").click(function() {
        var pushtimu = "";
        pushitimu = $("#duoxuan-timu div p").text() + "<br/>";
        pushitimu = pushitimu + "A:" + $("#duoxuan-daan1 div p").text() + "<br/>" +
                                "B:" + $("#duoxuan-daan2 div p").text() + "<br/>";
        if ($(".box-title2").children('.keyList:eq(2)').attr('class')=='keyList behide3') {
            pushitimu = pushitimu + "C:" + $("#duoxuan-daan3 div p").text() + "<br/>";
            if ($(".box-title2").children('.keyList:eq(3)').attr('class')=='keyList behide4') {
                pushitimu = pushitimu + "D:" + $("#duoxuan-daan4 div p").text() + "<br/>";
                if ($(".box-title2").children('.keyList:eq(4)').attr('class')=='keyList behide5') {
                    pushitimu = pushitimu + "E:" + $("#duoxuan-daan5 div p").text() + "<br/>";
                    if ($(".box-title2").children('.keyList:eq(5)').attr('class')=='keyList behide6') {
                        pushitimu = pushitimu + "F:" + $("#duoxuan-daan6 div p").text() + "<br/>";
                    }
                }
            }
        }
        $("#handle-2 li:eq("+settimuindex+") .handle-timu").html(pushitimu);
        $(".insert-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });
    $("#tijiao-tiankong").click(function() {
        var pushtimu = "";
        pushitimu = $("#tiankong-timu div p").text() + "<br/>";
        pushitimu = pushitimu + "第一空:" + $("#tiankong-daan1 div p").text() + "<br/>";
        if ($(".box-title3").children('.keyList:eq(1)').attr('class')=='keyList behide2') {
            pushitimu = pushitimu + "第二空:" + $("#tiankong-daan2 div p").text() + "<br/>";
            if ($(".box-title3").children('.keyList:eq(2)').attr('class')=='keyList behide3') {
                pushitimu = pushitimu + "第三空:" + $("#tiankong-daan3 div p").text() + "<br/>";
                if ($(".box-title3").children('.keyList:eq(3)').attr('class')=='keyList behide4') {
                    pushitimu = pushitimu + "第四空:" + $("#tiankong-daan4 div p").text() + "<br/>";
                    if ($(".box-title3").children('.keyList:eq(4)').attr('class')=='keyList behide5') {
                        pushitimu = pushitimu + "第五空:" + $("#tiankong-daan5 div p").text() + "<br/>";
                        if ($(".box-title3").children('.keyList:eq(5)').attr('class')=='keyList behide6') {
                            pushitimu = pushitimu + "第六空:" + $("#tiankong-daan6 div p").text() + "<br/>";
                        }
                    }
                }
            }
        }
        $("#handle-3 li:eq("+settimuindex+") .handle-timu").html(pushitimu);
        $(".insert-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });
    $("#tijiao-panduan").click(function() {
        var pushtimu = "";
        pushitimu = $("#tiankong-timu div p").text() + "<br/>";
        alert($(".box-title4 input[type='radio']:checked").val());
        $("#handle-4 li:eq("+settimuindex+") .handle-timu").html(pushitimu);
        $(".insert-timu-black").css({
            'z-index': '-1',
            'opacity': '0'
        });
    });*/
    $(".subup").click(function() {
        var comment = [];
        var type = [];
        var zhiye = [];
        var daan = [];
        var tip = [];
        $(".details").each(function(index, el) {
             comment.push($(el).find('.subcom .subl span').text());
             type.push($(el).find('.subt .subl .typeid span').text());
             daan.push($(el).find('.subcom .subr .subans span').text());
             tip.push($(el).find('.subcom .subr .subtip span').text());
             zhiye.push($(el).find('.subt .subl .proid span').text());
        });
        /*alert(zhiye);*/
        $.ajax({
            type: "POST",
            url: "sendup.do",
            data: {
                'commentList' : comment,
                'typeList' : type,
                'realAnswerList' : daan,
                'tipList' : tip,
                'professionIdList' : zhiye
            },
            dataType: "json",
            success: function(data){
                if (data==1) {
                    alert("上传成功");
                }else{
                    alert("上传失败");
                }
            }
        });
    });
});