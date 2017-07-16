$(document).ready(function() {
    var timuindex = 0;
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
        $(".add-timu-black").css({
            'z-index': '85000',
            'opacity': '1'
        });
        timuindex = $(this).parent().parent().index();
    });
    $(document).on("click",".insert-timu",function(){
        $(".insert-timu-black").css({
            'z-index': '85000',
            'opacity': '1'
        });
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
        $('<li><div class="drag-handle">&#9776;</div><div class="handle-timu"></div><div class="timu-info">题目分值：<input type="text">分<br>题目类型：<select class="title-select" name="">  <option class="title1" value="1">单选</option> <option class="title2" value="2">多选</option> <option class="title3" value="3">填空</option> <option class="title4" value="4">判断</option> <option class="title5" value="5">开放题</option> </select><br><div class="select-timu">选择题目</div><div class="insert-timu">录入题目</div><span class="glyphicon glyphicon-remove" title="删除题目"></span></div></li>').insertBefore(this);
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
});