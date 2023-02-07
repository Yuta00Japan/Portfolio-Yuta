<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上データ閲覧</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/SalesView.css">
</head>
<body>
<h1>売上額、仕入額、売上総利益を参照できます</h1>
<p>閲覧したい期間を選択してください</p>
<form action ="/Inventory_Management_System/AnalysisControler" method="Get">
<h2>開始日：<input type ="date" name="startday" required></h2>
<h3>終了日：<input type="date" name="endday" required></h3>
<h4>　決定：<input type="submit" value="決定"></h4>
</form>
</body>
</html>