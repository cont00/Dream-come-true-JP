/*
 * メイン画面のイメージを自動的に次のイメージで伝えるために作られたイベントページ
 */

$(document).ready(function() {
//	$('.#mainslider>div').css('margin-left', '0px');
//	$('.#mainslider>div').css('margin-left', '-750px');
//	$('.#mainslider>div').css('margin-left', '-1500px');
//	$('.#mainslider>div').css('margin-left', '-2250px');
	
	var margin = 0;
	var auto_margin = setInterval( function() {  
		margin = margin - 750;
		if(margin < -3750){
			margin = 0;
		}
		$('#mainslider>#move').css('margin-left', margin + 'px');
	}  , 2000);
	
//	function stop_margin() {
//		clearInterval(auto_margin);
//	}
	
	$('#left').click( function() {
//		alert('경고창1');
		clearInterval(auto_margin);
		var cur_margin = $('#mainslider>#move').css('margin-left');
		cur_margin = parseInt(cur_margin);
//		alert(cur_margin);
		if (cur_margin == 0) {
			cur_margin = -3750;
		}
		else {
			cur_margin = cur_margin + 750;
		}
		$('#mainslider>#move').css('margin-left', cur_margin + 'px');
	});
	
	$('#right').click( function() {
//		alert('경고창2');
		clearInterval(auto_margin);
		var cur_margin = $('#mainslider>#move').css('margin-left');
		cur_margin = parseInt(cur_margin);
//		alert(cur_margin);
		if (cur_margin == -3750) {
			cur_margin = 0;
		}
		else {
			cur_margin = cur_margin - 750;
		}
		$('#mainslider>#move').css('margin-left', cur_margin + 'px');
	});
	
	$('.a').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', 0 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
	$('.b').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', -750 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
	$('.c').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', -1500 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
	$('.d').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', -2250 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
	$('.e').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', -3000 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
	$('.f').click( function() {
		clearInterval(auto_margin);
		$('#mainslider>#move').css('margin-left', -3750 + 'px');
		$.each($('span') , function() {
			$(this).css('color', 'black');
		});
		$(this).css('color', 'blue');
	});
});

function writeForm() {
//	alert('경고창');
	location.href="/Freeboard/writeForm.jsp";
}

function Freeboard() {
	location.href="/Freeboard/Freeboard.jsp";
}

function updateForm() {
	location.href="/Freeboard/updateForm.jsp"
}

function deleteForm() {
	location.href="/Freeboard/deleteForm.jsp"
}