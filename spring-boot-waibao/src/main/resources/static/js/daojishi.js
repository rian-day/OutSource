var number = "";
var status = "";
$(function() {
	function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    var id = getUrlParam("id");//获取试卷id
    var url = "";
    var args = {"id":id};
    $.post(url,args,function(data){
    		//查找该试卷的考试时长
    		number = data;
    		status = "yes";
    })
	if(status == "yes"){
	var target_date = new Date().getTime() + (60000 * number); // set the countdown date
	var days, hours, minutes, seconds; // variables for time units

	var countdown = document.getElementById("tiles"); // get tag element
	getCountdown();

	setInterval(function () { getCountdown(); }, 1000);

	function getCountdown(){

		// find the amount of "seconds" between now and target
		var current_date = new Date().getTime();
		var seconds_left = (target_date - current_date) / 1000;

		days = pad( parseInt(seconds_left / 86400) );
		seconds_left = seconds_left % 86400;
		 
		hours = pad( parseInt(seconds_left / 3600) );
		seconds_left = seconds_left % 3600;
		  
		minutes = pad( parseInt(seconds_left / 60) );
		seconds = pad( parseInt( seconds_left % 60 ) );

		// format countdown string + set tag value
		countdown.innerHTML = "<span>" + hours + ":</span><span>" + minutes + ":</span><span>" + seconds + "</span>"; 
	}

	function pad(n) {
		return (n < 10 ? '0' : '') + n;
	}
}
});