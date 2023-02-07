<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログ監視システム</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/LogSearch.css">
</head>
<body>
<h1>ログ監視システム</h1>
<p>参照したい期間を入力してください</p>
<form action = "/Inventory_Management_System/LogSearchControler" method = "Get">
<h2>開始日：<input type = "date" name = "startDay" id="start" required></h2>
<h3>終了日：<input type = "date" name = "endDay" id="end" required></h3>
<h4>・収納記録<input type = "radio" name = "or" value = "warehousing" required>
・引出記録<input type = "radio" name = "or" value = "dispatching" required></h4>
<h5><input type = "submit" name = "select" value = "logSearch"></h5>
</form>

</body>
</html>