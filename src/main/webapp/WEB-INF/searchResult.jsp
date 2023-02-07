<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/searchResult.css">
</head>
<body>
<h1>こちらからホームに戻れます。</h1>
<form action = "/Inventory_Management_System/ReturnControler" method = "Get">
<h2><input type = "submit" name = "select" value = "home"></h2>
</form>
<h3>検索結果は以下の通りです</h3>
<table border="1" class = "table">
<tr>
<th>商品番号</th>
<th>商品名</th>
<th>仕入価格</th>
<th>販売価格</th>
<th>商品在庫</th>
<th>商品種別</th>
<th>備考</th>
</tr>
<c:forEach var="i" begin ="0" end ="${result.itemCode.size()-1}" step ="1">
<tr>  	
<td><c:out value="${result.itemCode.get(i)}"/></td>
<td><c:out value="${result.itemName.get(i)}"/></td>
<td><c:out value="${result.itemPrice.get(i) }"/></td>
<td><c:out value="${result.salesPrice.get(i)}"/></td>
<td><c:out value="${result.itemStock.get(i) }"/></td>
<td><c:out value="${result.itemType.get(i)}"/></td>
<td><c:out value="${result.itemNote.get(i) }"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>