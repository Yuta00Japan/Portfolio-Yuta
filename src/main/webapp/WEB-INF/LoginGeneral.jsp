<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理システム</title>
<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath() %>/Css/LoginGeneral.css">
</head>
<body>
<div class="time">
<h1 id ="date">今日の日付</h1>
</div>

<h1 id="realtime"></h1>

<h1 class = "announce"><span class="back">社員番号と暗証番号を入力してください</span></h1>
<form action = "/Inventory_Management_System/LoginControler" method = "post">
<h2 class = "empCode"><span class="back">従業員番号：<input type = "text" name = "empCode" minlength ="4"  maxlength = "4" required></span></h2>
<h3 class = "password" ><span class="back">パスワード:<input type = "password"  name = "password" required></span></h3>
<h4 class = "submit"><input type = "submit" name = "select" value = "login"></h4>
</form>
<div class="error">
<span>${error}</span>
</div>
<script>

//現座日時を表示する
function showClock() {
    let nowTime = new Date();
    let nowHour = nowTime.getHours();
    let nowMin  = nowTime.getMinutes();
    let nowSec  = nowTime.getSeconds();
	
	if(nowHour < 10){

		nowHour = "0"+nowHour;
	}
	if(nowMin < 10){

		nowMin = "0"+nowMin;
	}
	
	if(nowSec < 10){

		nowSec = "0"+nowSec;
	}
    
    let msg = "現在時刻：" + nowHour + "時" + nowMin + "分" + nowSec+ "秒";
    document.getElementById("realtime").innerHTML = msg;
    
  }
  setInterval('showClock()',1000);
  
function showdate(){
	
	let day = new Date();
	let month = day.getMonth()+ 1;
	let date = day.getDay();
	
	switch(date){

	case 0:
		date = "日";
		break;
	case 1:
		date = "月"
		break;
	case 2:
		date = "火"
		break;
	case 3:
		date = "水"
		break;
	case 4:
		date = "木"
		break;
	case 5:
		date = "金";
		break;
	case 6:
		date = "土"
		break;
	}
	let msg = "現在の日付 "+day.getFullYear()+"年"+month+"月"+day.getDate()+"日 "+date+"曜日";
	document.getElementById("date").innerHTML = msg;
}
	setInterval('showdate()',1000);

//時間帯によって背景画像を変更する
function background(){
	let time = new Date();

	let hour = time.getHours();

	if(hour > 6 && hour < 18){
		document.body.style.backgroundImage = 'url("http://localhost:8080/Inventory_Management_System/Image/階段.jpg")';
	}else{
		document.body.style.backgroundImage = 'url("http://localhost:8080/Inventory_Management_System/Image/階段夜.jpg")';
	}
	
}
	setInterval('background()',1000);

</script>
</body>
</html>