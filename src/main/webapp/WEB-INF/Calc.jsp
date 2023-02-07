<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>  売上原価：${analysis.cost }</h2>
<h3>  売上金額：${analysis.sales }</h3>
<h4>売上総利益：${analysis.benefit }</h4>
<form action="/Inventory_Management_System/ReturnControler" method="Get">
<h5 id="return"><input type="submit" value="戻る"></h5>
</form>
</body>
</html>