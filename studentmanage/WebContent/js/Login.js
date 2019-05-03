/**
 * 
 */
$.backstretch([
        'loginimage/0.jpg',
        'loginimage/1.jpg',
        'loginimage/2.jpg',
        'loginimage/3.gif',
        'loginimage/4.jpg',
        'loginimage/5.gif',
        'loginimage/6.jpg',
        'loginimage/7.jpg',
        'loginimage/8.jpg',
    ], {
        fade : 1000, // 动画时长
        duration : 1000 // 切换延时
});
$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});
function refresh() {
	var picture1 = document.getElementById("picture1");
	var i = Math.random();
	picture1.src="number.jsp?id="+i;
}
function refresh2() {
	var picture2 = document.getElementById("picture2");
	var i = Math.random();
	picture2.src="number.jsp?id="+i;
}
function refresh3() {
	var picture3 = document.getElementById("picture3");
	var i = Math.random();
	picture3.src="number.jsp?id="+i;
}