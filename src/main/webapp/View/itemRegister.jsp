<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link rel ="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Css/itemRegister.css">
</head>
<body>
<h1>商品登録フォーム</h1>
<p><span id="back">こちらでは新規商品を登録することができます</span></p>
<form action = "/Inventory_Management_System/RegisterControler" method = "post" id="form">
<h2>　商品名：<input type = "text" name = "name" required></h2>
<h3>仕入価格：<input type = "number" name = "price" id="cost" min="1" required></h3>
<h3>販売価格：<input type="number" name = "salesprice" id="price" min ="1" required></h3>
<h4>　在庫数：<input type = "number" name = "stock" min="1" required></h4>
<h5>商品種別：<select name = "type" required>
         <option value = "1">食品</option>
         <option value = "2">衣服</option>
         <option value = "3">雑貨</option>
         <option value = "4">家電</option>
         </select>
備考：<input type = "text" name = "note" ></h5>
<h6 class ="submit">送信：<input type = "submit" name = "select" value = "insert" >
リセット：<input type = "reset"></h6>
</form>
<script>
//売価が原価を下回っていた場合の処理
document.getElementById('form').addEventListener('submit',quantityCheck);

function quantityCheck(event){
	let cost = document.getElementById('cost').value;
	let price = document.getElementById('price').value;

	if(cost > price){
		//event cancel
		alert('販売価格が原価を下回っています！');
		 event.stopPropagation();
	     event.preventDefault();
	     
	}else{
		
	}
}
</script>
</body>
</html>