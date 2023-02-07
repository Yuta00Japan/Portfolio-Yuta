<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正画面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/ModifyExecute.css">
</head>
<body>
<h1>修正画面です</h1>
<p>書き換えたい内容を入力してください</p>
<div class ="info">
<h2>
<nobr>商品番号：<c:out value="${data.itemCode.get(0)}"/></nobr><br><nobr>商品名：<c:out value="${data.itemName.get(0)}"/></nobr><br>
<nobr>仕入価格：<c:out value="${data.itemPrice.get(0)}"/></nobr><br><nobr>販売価格：<c:out value="${data.salesPrice.get(0) }"/></nobr><br>
<nobr>在庫：<c:out value="${data.itemStock.get(0)}"/></nobr><br>
<nobr>商品種別：<c:out value="${data.itemType.get(0)}"/></nobr><br><nobr>備考：<c:out value="${data.itemNote.get(0)}"/></nobr></h2>
<h3 class="pointer">➡</h3>
<h4>
<nobr>商品名：<span id ="item0"></span></nobr><br>
<nobr>仕入価格：<span id = "item1"></span></nobr><br>
<nobr>販売価格：<span id="item2"></span></nobr><br>
<nobr>在庫：<span id ="item3"></span></nobr><br>
<nobr>商品種別：<span id="item4"></span></nobr><br>
<nobr>備考：<span id="item5"></span></nobr><br>
</h4>
</div>
<form action = "/Inventory_Management_System/ExecuteControler" method = "post" id="form">
<div class ="enter">
商品名：<input type = "text" name = "itemname" id="ch0"  onchange="output(0);" required>
仕入価格：<input type = "number" name = "itemprice" id="ch1" onchange="output(1);" required>
販売価格：<input type="number" name="salesPrice" id="ch2" onchange="output(2);">
商品在庫：<input type = "number" name = "itemstock" id="ch3" onchange="output(3);" required>
商品種別：<select name = "itemtype" id="ch4" onchange="output(4);" required>
           <option value = "1">食品</option>
           <option value = "2">衣服</option>
           <option value = "3">雑貨</option>
           <option value = "4">家電</option>
          </select>
商品備考：<input type = "text" name = "itemnote" id="ch5" onchange="output(5);">
</div>
<h3><input type = "submit" name = "select" value ="登録内容修正"></h3>
</form>
<script>

document.getElementById('form').addEventListener('submit',priceCheck);

//入力内容を出力するメソッド
function output(i){
    let content;
    switch(i){

    case 0:
        content = document.getElementById('ch0').value;
        document.getElementById('item0').textContent =  content;
    	break;
    case 1:
        content = document.getElementById('ch1').value;
        document.getElementById('item1').textContent =  content;
        break;
    case 2:
        content = document.getElementById('ch2').value;
        document.getElementById('item2').textContent =  content;
        break;
    case 3:
        content = document.getElementById('ch3').value;
        document.getElementById('item3').textContent = content;
        break;
    case 4:
        content = document.getElementById('ch4').value;   
        switch(content){
			
        case '1':
            content = '食品';
            break;
        case '2':
            content = '衣服';
            break;
        case '3':
            content = '雑貨';
            break;
        case '4':
            content = '家電';
            break;
        }
        
        document.getElementById('item4').textContent =  content;
        break;
    case 5:
        content = document.getElementById('ch5').value;
        document.getElementById('item5').textContent =  content;
        break;
    }

}
//売価が原価を下回っていた場合処理を中断しポップアップ
function priceCheck(event){
	let cost = document.getElementById('ch1').value;
	let price = document.getElementById('ch2').value;

	if(cost > price){
		alert('売価が原価を下回っています！');
		  event.stopPropagation();
	      event.preventDefault();
	}
}
</script>
</body>
</html>