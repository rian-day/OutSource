var page = 0;
    $(".pagingUl li").click(function() {
        page = $(this).children("a").text();
         var obj = $(this).children('a');
        $(".activP").removeClass("activP");
        obj.addClass("activP");
        pageCut(page);
    })
    $(".next").click(function() {
        page = $(".activP").text()*1+1;
        if($(".pagingUl li:last").children('a').text() >= page){
            pageCut(page)
            var obj = $(".activP").parent().next().children('a');
            $(".activP").removeClass("activP");
            obj.addClass("activP");
        }else{
            page -= 1;
        }
    })
    $(".prv").click(function() {
        var page = $(".activP").text()*1 - 1;
        if($(".pagingUl li:first").children('a').text() > page){
            page += 1;
        }else{
            pageCut(page)
            var obj = $(".activP").parent().prev().children('a');
            $(".activP").removeClass("activP");
            obj.addClass("activP");
        }
    })
    $(".last").click(function(){
        page = $(".pagingUl li:last").children('a').text()*1;
        pageCut(page)
        var obj =$(".pagingUl li:last").children('a');
        $(".activP").removeClass("activP");
        obj.addClass("activP");

    });
     $(".first").click(function(){
        page = 1;
        pageCut(page)
        var obj =$(".pagingUl li:first").children('a');
        $(".activP").removeClass("activP");
        obj.addClass("activP");
        
    });
