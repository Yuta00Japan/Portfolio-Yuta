<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正画面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/Modify.css">
</head>
<body>
<h1><span class="back">こちらで商品の登録内容を修正できます</span></h1>
<h2><span class="back">修正したい商品の番号を入力してください</span></h2>
<form action = "/Inventory_Management_System/RevisionControler" method = "post">
<h3>商品番号:<input type = "number" name = "number" required></h3>
<h4><input type = "submit" name = "select" value = "modify"></h4>
</form>
<h5><span>${error}</span></h5>
</body>
</html>