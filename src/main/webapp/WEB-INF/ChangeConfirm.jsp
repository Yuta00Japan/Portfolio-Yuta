<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*"%>
    <%@page import="model.SearchResultBeans" %>
    <%@page import="model.ClientBeans" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/Css/ChangeConfirm.css">
</head>
<body id="body">
<h1>ご確認ください</h1>
<div id="detail">

<table border="1" id="itemTable">
<tr>
<th>商品ID</th>
<th>商品名</th>
<th>商品原価</th>
<th>在庫</th>
<th>操作数量</th>
<th>在庫操作</th>
</tr>
<%--取引する商品情報を記述している --%>
<c:forEach var="i" begin="0" end="${item.size()-1}" step="1">
<tr>
	<td><c:out value="${item.get(i).getItemCode().get(0) }"/></td>
	<td><c:out value="${item.get(i).getItemName().get(0) }"/></td>
	<td id="cost"><c:out value="${item.get(i).getItemPrice().get(0)}"/></td>
	<td><c:out value="${item.get(i).getItemStock().get(0)}"/></td>
	<td><c:out value="${quantity[i] }"/></td>
	<td><c:out value="${method[i] }" /></td>
</tr>
</c:forEach>
</table>

<table border="1" id="dealInfo">
<tr>
<th>担当者番号</th>
<th>担当者名</th>
</tr>
<tr><%--担当者情報 --%>
<td><c:out value="${user.code }"/></td>
<td><c:out value="${user.name }"/></td>
</tr>
<tr>
<th>取引先番号</th>
<th>取引先会社名</th>
</tr><%--取引先情報 --%>
<c:forEach var="i" begin="0" end="${client.size()-1 }" step="1">
<tr>
<td><c:out value="${client.get(i).getDealCode().get(0) }"/></td>
<td><c:out value="${client.get(i).getClientName().get(0) }"/></td>
</tr>
</c:forEach>
</table>
<h2 id="cash">入庫金額<c:out value="${warehousing }"/><br>
出庫金額<c:out value="${dispatching }"/></h2>
</div>
<form action = "/Inventory_Management_System/ExecuteControler" method = "post">
<h3 class = "checkbox">確認いたしました。<input type = "checkbox" required></h3>
<input type = "submit" name = "select" value = "在庫移動">
</form>

</body>
</html>