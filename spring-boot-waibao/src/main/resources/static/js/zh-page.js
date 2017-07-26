$(document).ready(function() {
	var obPage = 0;
	var tbPage = 0;
	var oaPage = 0;
	var taPage = 0;

	var toPage = 0;
	
	if (countPage<nowPage) {
		alert('请输入正确页数!');
	}

	function nowpage(nowPage){
		tbPage = nowPage - 2;
		obPage = nowPage - 1;
		oaPage = nowPage + 1;
		taPage = nowPage + 2;
	}
	

	
	if(countPage==1){
		$(".tbPage").attr({
			'style' : 'display:none'
		});
		$(".obPage").attr({
			'style' : 'display:none'
		});
		$(".oaPage").attr({
			'style' : 'display:none'
		});
		$(".taPage0").attr({
			'style' : 'display:none'
		});
		$(".paging ul").attr({
			'style' : 'width:35px'		
		});
		$(".paging").attr({
			'style' : 'width:215px'		
		});

		$(".nowPage").text(1);
		$(".nowPage").attr({'id': 'pactive'});
	}else if(countPage==2){
		$(".tbPage").attr({
			'style' : 'display:none'
		});
		$(".nowPage").attr({
			'style' : 'display:none'
		});
		$(".taPage0").attr({
			'style' : 'display:none'
		});
		$(".paging ul").attr({
			'style' : 'width:70px'		
		});
		$(".paging").attr({
			'style' : 'width:250px'		
		});


		$(".obPage").text(1);
		$(".oaPage").text(2);

		if (nowPage==1) {
			$(".obPage").attr({'id': 'pactive'});
		}else if (nowPage==2) {
			$(".oaPage").attr({'id': 'pactive'});
		}
	}else if(countPage==3){
		$(".tbPage").attr({
			'style' : 'display:none'
		});
		$(".taPage0").attr({
			'style' : 'display:none'
		});
		$(".paging ul").attr({
			'style' : 'width:105px'		
		});
		$(".paging").attr({
			'style' : 'width:285px'		
		});

		$(".obPage").text(1);
		$(".nowPage").text(2);
		$(".oaPage").text(3);

		if (nowPage==1) {
			$(".obPage").attr({'id': 'pactive'});
		}else if (nowPage==2) {
			$(".nowPage").attr({'id': 'pactive'});
		}else if (nowPage==3) {
			$(".oaPage").attr({'id': 'pactive'});
		}
	}else if(countPage==4){
		$(".nowPage").attr({
			'style' : 'display:none'
		});
		$(".paging ul").attr({
			'style' : 'width:140px'		//少一个-35px;
		});
		$(".paging").attr({
			'style' : 'width:320px'		//少一个-35px;
		});

		$(".tbPage").text(1);
		$(".obPage").text(2);
		$(".oaPage").text(3);
		$(".taPage").text(4);

		if (nowPage==1) {
			$(".tbPage").attr({'id': 'pactive'});
		}else if (nowPage==2) {
			$(".obPage").attr({'id': 'pactive'});
		}else if (nowPage==3) {
			$(".oaPage").attr({'id': 'pactive'});
		}else if (nowPage==4) {
			$(".taPage").attr({'id': 'pactive'});
		}
	}else{
		if(nowPage==1){
			nowPage = 3;
			nowpage(nowPage);

			$(".tbPage").attr({'id': 'pactive'});

			$(".nowPage").text(nowPage);

			$(".obPage").text(obPage);
			$(".tbPage").text(tbPage);

			$(".oaPage").text(oaPage);
			$(".taPage").text(taPage);
		}else if (nowPage==2) {
			nowPage = 3;
			nowpage(nowPage);

			$(".obPage").attr({'id': 'pactive'});

			$(".nowPage").text(nowPage);

			$(".obPage").text(obPage);
			$(".tbPage").text(tbPage);

			$(".oaPage").text(oaPage);
			$(".taPage").text(taPage);
		}else if (nowPage==(countPage-1)) {
			nowPage = countPage - 2;
			nowpage(nowPage);

			$(".oaPage").attr({'id': 'pactive'});

			$(".nowPage").text(nowPage);

			$(".obPage").text(obPage);
			$(".tbPage").text(tbPage);

			$(".oaPage").text(oaPage);
			$(".taPage").text(taPage);
		}else if (nowPage==countPage) {
			nowPage = countPage - 2;
			nowpage(nowPage);

			$(".taPage").attr({'id': 'pactive'});

			$(".nowPage").text(nowPage);

			$(".obPage").text(obPage);
			$(".tbPage").text(tbPage);

			$(".oaPage").text(oaPage);
			$(".taPage").text(taPage);
		}else{
			tbPage = nowPage - 2;
			obPage = nowPage - 1;
			oaPage = nowPage + 1;
			taPage = nowPage + 2;

			$(".nowPage").attr({'id': 'pactive'});

			$(".nowPage").text(nowPage);

			$(".obPage").text(obPage);
			$(".tbPage").text(tbPage);

			$(".oaPage").text(oaPage);
			$(".taPage").text(taPage);

		}
	}




	$(".paging ul li").click(function() {
		toPage = $(this).text();
		topage(toPage);
	});
	$(".paging .lastPage").click(function() {
		toPage = nowPage - 1;
		if (toPage>=1) {
			topage(toPage);
		}
	});
	$(".paging .nextPage").click(function() {
		toPage = nowPage + 1;
		if (toPage<=countPage) {
			topage(toPage);
		}else{
			
		}
	});
	$(".paging .firstPage").click(function() {
		topage(1);
	});
	$(".paging .finalPage").click(function() {
		topage(countPage);
	});
})