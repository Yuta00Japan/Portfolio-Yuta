<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理システム</title>
<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath() %>/Css/Opening.css">
</head>
<body>
<h1>ようこそ！<c:out value ="${user.department}"/>の<c:out value="${user.name}"/>さん！</h1>
<h2>職位：<c:out value ="${user.post }"/>---権限：<c:out value="${user.authority }"/></h2>
<%--エラーメッセージ表示 --%>
<h3>${error}</h3>
<h3 class = "depowith"><a href = "View/Deposit_withdraw.jsp">商品管理</a></h3>
<h3 class = "itemregister"><a href = "View/itemRegister.jsp">新商品登録</a></h3>
<h3 class = "itemsearch"><a href = "View/itemSearch.jsp">商品検索</a></he>
<h3 class = "modify"><a href = "View/Modify.jsp">商品登録内容修正</a></h3>
<h3 class = "logsearch"><a href = "View/LogSearch.jsp">ログ監視</a></h3>
<h3 class="itemregister"><a href="View/SalesView.jsp">現在の進捗</a></h3>

<form action = "/Inventory_Management_System/LogoutControler" method = "post">
<input type = "submit" name = "select" value = "logout">
</form>
</body>
</html>