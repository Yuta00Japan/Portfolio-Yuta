<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath() %>/Css/Deposit_withdraw.css">
</head>
<body id="body">
<h1>商品管理データベースです。</h1>

<%--エラー表示 --%>
<h2 class="error">${error}</h2>

<%--フォームに入力後にこのボタンをクリックして配列に追加する仕組み --%>
<h2><button id="btn">取引内容追加</button></h2>

<p>現在の取引数：<span id="count">0</span>回</p>

<form action = "/Inventory_Management_System/InventoryUpdateControler" onsubmit="return addFinish()" method = "post" id="form">
<h2>商品番号<input type = "number" name = "itemId" id="itemnumber"></h2>
<h3>数量<input type = "number" name = "quantity" id="quantity" min="1"></h3>
<h4>入庫<input type = "radio" name = "method" id="or" value = "storage" checked>
    出庫<input type = "radio" name = "method" id="or" value = "withdrawal"></h4>
    <h5>取引先番号<input type = "number" name = "deal" id="dealcode"></h5>
    
    <%--javascriptの配列を受け取り送信するためのもの --%>
    <input type="hidden" name ="itemNumber" id="itemNumber">
    <input type="hidden" name ="itemQuantity" id="itemQuantity">
    <input type="hidden" name ="itemMethod" id="itemMethod">
    <input type="hidden" name ="dealCode" id="dealCode">
<h6><input type = "submit" name = "select" value = "update"></h6>
	
</form>


<script>
//商品を複数取引するためのmethod群

//取引内容を追加するもの
document.getElementById('btn').addEventListener('click',add);

//配列の初期化
window.addEventListener('unload',cancel);

//入力回数を記録する
var count = 0;

/**
 * 取引内容を格納する
 */
var itemid = [];
var quantity = [];
var method =[];
var dealcode = [];


//商品追加
function add(){
	//フォームの内容を格納しカウントを増加
	
	let item = document.getElementById('itemnumber').value;
	let amount = document.getElementById('quantity').value;
	let deal = document.getElementById('dealcode').value;

	//フォーム入力チェック
	if(item == "" || item == null){
		alert('すべて入力してください');
		return false;
	}
	if(amount =="" || amount == null){
		alert('すべて入力してください');
		return false;
	}
	if(deal == "" || deal == null){
		alert('すべて入力してください');
		return false;
	}
	
	//入力内容を配列に追加
	itemid[count] = item;
	quantity[count] = amount;

	//ラジオボタンの処理
	let radio = document.querySelectorAll('#or');

	for(let i = 0; i < radio.length; i++){

		if(radio[i].checked== true){

			method[count]=radio[i].value;
		}
	}
	
	dealcode[count] = deal;
	//格納し終えたらカウントを増やし、初期化する
	count++;
	document.getElementById('count').textContent = count;
	
	//フォーム内容の初期化
	document.getElementById('itemnumber').value = null;
	document.getElementById('quantity').value = null;	
	document.getElementById('dealcode').value = null;		
}
//商品登録確定＆カウントリセット
function addFinish(){
//もし一つも取引が入力されていなければsubmitをキャンセルさせる、
	if(count <= 0){
		alert('まだ取引内容が入力されていません');
		return false;
	}
	
	document.getElementById('itemNumber').value= itemid;
	document.getElementById('itemQuantity').value= quantity;
	document.getElementById('itemMethod').value= method;
	document.getElementById('dealCode').value= dealcode;

	count = 0;

	return true;
}
//キャンセルされたら配列の要素をすべて削除
function cancel(){
	itemId.length = 0;
	quanity.length = 0;
	method.length = 0;
	dealcode.length = 0;
}

</script>
</body>
</html>