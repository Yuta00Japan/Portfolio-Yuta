<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href ="<%=request.getContextPath()%>/Css/LogSearchResult.css">
</head>
<body>
<h1>ログ監視システム</h1>
<c:choose>
<c:when test ="${choise.equals('warehousing')}">
<h2>入庫記録</h2>
</c:when>
<c:otherwise>
<h2>出庫記録</h2>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${data.officer.size()<= 0 }">
<h3>まだ記録がありません</h3>
</c:when>
<c:otherwise>
<table border ="1">
<tr>
<th>担当者</th>
<th>商品名</th>
<th>原価</th>
<th>売価</th>
<th>数量</th>
<th>取引日時</th>
<th>取引先</th>
</tr>
<c:forEach var ="i" begin = "0" end = "${data.officer.size()-1}" step ="1">
<tr>
<td><c:out value ="${data.officer.get(i)}"/></td>
<td><c:out value ="${data.itemName.get(i)}"/></td>
<td><c:out value="${data.cost.get(i) }"/></td>
<td><c:out value="${data.price.get(i) }"/></td>
<td><c:out value="${data.quantity.get(i)}"/></td>
<td><c:out value="${data.dealTime.get(i)}"/></td>
<td><c:out value="${data.client.get(i)}"/></td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</body>
</html>