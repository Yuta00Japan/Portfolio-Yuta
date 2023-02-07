package model;

import database.ItemTableDAO;

public class ItemSearchLogic {
	
	/**
	 * 全商品の情報を取り出す
	 * @return　全商品の情報
	 * @throws Exception
	 */
	public Object SearchItemAll() throws Exception{
		
		ItemTableDAO it = new ItemTableDAO();
		
		return it.showTable();
	}
	
	
	//簡易的に検索する際に使用する
	/**
	 * 
	 * @param itemId 	商品ID
	 * @return　商品情報
	 * @throws Exception
	 */
	public Object SearchItem(String itemId) throws Exception {
		
		ItemTableDAO itd = new ItemTableDAO(itemId);
		
		return itd.showTable();
	}
	//itemSearch.jspで使用するメソッドです。
	/**
	 * 
	 * @param nameCode 商品IDか商品名
	 * @param exception　
	 * @param startPrice　価格指定（売価）始め
	 * @param endPrice　価格指定（売価）終わり
	 * @return　商品情報
	 * @throws Exception
	 */
	public Object SearchLogic(String nameCode ,String exception,String startPrice,String endPrice) throws Exception {
	   //商品番号で検索された場合の処理
	   if(nameCode.matches("[0-9]{4}")) {
		   
		   ItemTableDAO itd = new ItemTableDAO(nameCode);
		   
		   return itd.showTable();
	   }else {
		   //exceptionが入力されていなければ
		   if(exception.equals("")|| exception.equals(null)) {
			   
			   exception = "NOTEXCEPTION";
		   }
		   
		   ItemTableDAO itd = new ItemTableDAO(nameCode,exception,startPrice,endPrice);
		   
		   return itd.showTable();
	   }
   }
}
