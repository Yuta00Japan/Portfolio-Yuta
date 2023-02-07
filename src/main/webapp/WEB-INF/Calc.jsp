<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>現在の実績</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/Calc.css">
</head>
<body>
<h1>現在の進捗状況</h1>
<p>開始日の午前６時から終了日の午後２２時までの取引内容で計算されます</p>
<h2>  売上原価：<span id="cost">${analysis.cost }</span>円</h2>
<h3>  売上金額：<span id="sales">${analysis.sales }</span>円</h3>
<h4>売上総利益：<span id="benefit"></span>円</h4>
<form action="/Inventory_Management_System/ReturnControler" method="Get">
<h5 id="return"><input type="submit" value="戻る"></h5>
</form>
<script>
//売上金額　売上原価から粗利を計算し、表示します
window.addEventListener('load',benefit);

function benefit(){
	let sales = document.getElementById('sales').textContent;
	let cost = document.getElementById('cost').textContent;

	document.getElementById('benefit').textContent = sales-cost;
}

</script>
</body>
</html>