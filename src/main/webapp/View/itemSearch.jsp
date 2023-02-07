<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品検索</title>
<link rel="stylesheet" type ="text/css" href ="<%=request.getContextPath()%>/Css/itemSearch.css">
</head>
<body>
<h1 class="announce"><span class="back">商品検索フォーム</span></h1>

<h1 id="all"><a href="/Inventory_Management_System/SearchControler?act=all">すべて参照する</a></h1>
<h1 class="error">${error }</h1>
<form action = "/Inventory_Management_System/SearchControler" method = "Get" id="form">
<h1><span class="back">商品名OR商品番号：<input type = "text" name = "name" id="nameCode" onchange="searchNumber();" required></span></h1>
<h2 id="except"><span class="back">除外ワード：<input type = "text" name = "exception"></span></h2>
        <h3 id="sele"><span class="back">価格指定（売価）：<select name = "startPrice" id="start"  required>
                  <option value = "0">0円</option>
                    <option value = "100">100円</option>
                      <option value = "500">500円</option>
                        <option value = "1000">1000円</option>
                          <option value = "2000">2000円</option>
                            <option value = "3000">3000円</option>
                              <option value = "4000">4000円</option>
                                <option value = "5000">5000円</option>
                                  <option value = "6000">6000円</option>
                                    <option value = "7000">7000円</option>
                                      <option value = "8000">8000円</option>
                                        <option value = "9000">9000円</option>
                                          <option value = "10000">10000円</option>
                                            <option value = "20000">20000円</option>
                                              <option value = "30000">30000円</option>
                                                <option value = "40000">40000円</option>
                                                  <option value = "50000">50000円</option>
                  </select>
                  ～
                  <select name = "endPrice" id="end"  required>
                   <option value = "100">100円</option>
                    <option value = "500">500円</option>
                     <option value = "1000">1000円</option>
                      <option value = "2000">2000円</option>
                        <option value = "5000">5000円</option>
                          <option value = "10000">10000円</option>
                           <option value = "20000">20000円</option>
                             <option value = "30000">30000円</option>
                               <option value = "40000">40000円</option>
                                 <option value = "50000">50000円</option>
                                   <option value = "60000">60000円</option>
                                     <option value = "70000">70000円</option>
                                       <option value = "80000">80000円</option>
                                         <option value = "90000">90000円</option>
                                           <option value = "100000">100000円</option>
                                             <option value = "110000">110000円</option>
                                               <option value = "120000">120000円</option>
                                                 <option value = "130000">130000円</option>
                                                   <option value = "140000">140000円</option>
                                                     <option value = "150000">150000円</option>
                                                       <option value = "160000">160000円</option>
                                                         <option value = "170000">170000円</option>
                                                           <option value = "180000">180000円</option>
                                                             <option value = "190000">190000円</option>
                                                               <option value = "200000">200000円</option>
                  </select></span></h3>
<h4><span class="back">決定：<input type = "submit" name = "select" value = "search"></span></h4>
</form>
<script>

document.getElementById('form').addEventListener('submit',priceCheck);

function searchNumber(){
	//商品コードで検索された場合、ほかのフォームを削除するメソッド
	let code = document.getElementById('nameCode').value;
	if(code.match('[0-9]{4}')){
		document.getElementById('except').remove();
		document.getElementById('sele').remove();
	}else{
		
	}
}

//価格帯指定が異常だった場合の処理
function priceCheck(event){

	let start = document.getElementById('start').value;
	let end = document.getElementById('end').value;

	//例：１４０００　～　５０００のような場合　正常に検索できないためキャンセル
	if(start > end){

		alert('正しく価格帯を指定してください');
		  event.stopPropagation();
	      event.preventDefault();
	}
	
}

</script>
</body>
</html>