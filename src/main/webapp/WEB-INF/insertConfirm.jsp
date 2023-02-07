<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容確認</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/insertConfirm.css">
</head>
<body>
<h1>登録内容は以下の通りでよろしいでしょうか？</h1>
<h2>　商品名：<c:out value="${data.itemName }"/></h2>
<h3>仕入価格：<c:out value="${data.price }"/>円</h3>
<h3>販売価格：<c:out value="${data.salesPrice }"/>円</h3>
<h4>商品在庫：<c:out value="${data.stock }"/>個</h4>

<c:choose>
<c:when test="${data.type == '1' }">
<h5>商品種別：<c:out value="食品"/></h5>
</c:when>

<c:when test="${data.type == '2' }">
<h5>商品種別：<c:out value="衣服"/></h5>
</c:when>

<c:when test="${data.type == '3' }">
<h5>商品種別：<c:out value="家電"/></h5>
</c:when>

<c:otherwise>
<h5>商品種別：<c:out value="雑貨"/></h5>
</c:otherwise>

</c:choose>
<h6>商品備考：<c:out value ="${data.note }"/></h6>
<form action = "/Inventory_Management_System/ExecuteControler" method = "post">
<h6 class="confirm">確認いたしました。<input type = "checkbox" required></h6>
<h6 class="submit"><input type = "submit" name = "select" value = "在庫追加"></h6>
</form>
</body>
</html>