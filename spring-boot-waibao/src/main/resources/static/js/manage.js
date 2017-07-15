$(document).ready(function() {
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
		var tid = $(this).attr("class");
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
});