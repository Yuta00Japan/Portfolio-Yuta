package model;

import database.AnalysisDAO;
import database.ItemTableDAO;

public class ExecuteLogic {
	//DAO関係をSERVLETから隔離するためのクラスです
	
	public ExecuteLogic() {
		
	}
	
	//商品を追加するためのconstructor
	/**
	 * 
	 * @param exe 商品登録内容
	 * @throws Exception
	 */
	public ExecuteLogic(InsertBeans exe) throws Exception {
		
		ItemTableDAO execute = new ItemTableDAO(exe.getItemName(),exe.getPrice(),exe.getSalesPrice(),exe.getStock(),exe.getType(),exe.getNote());
	}

	//在庫を出し入れするconstructor
	/**
	 * 
	 * @param user ユーザ情報
	 * @param ch　在庫移動内容
	 * @throws Exception
	 */
	public ExecuteLogic(UserInfoBeans user,ChangeBeans ch) throws Exception {
		
		ItemTableDAO exe = new ItemTableDAO(user,ch);
	}
	
	//出庫ログから売り上げ、売上原価、粗利を計算する
	/**
	 * 
	 * @param startDay 開始日
	 * @param endDay　終了日
	 * @return　売上、売上原価、粗利
	 * @throws Exception
	 */
	public Object calcSales(String startDay,String endDay) throws Exception {
		// 文字列のーを除去するロジック
		TimeModify tm = new TimeModify();
		
		AnalysisDAO search = new AnalysisDAO(tm.remove(startDay),tm.remove(endDay));
		
		return search.showTable();
	}
	
	//商品登録内容を修正するconstructor
	/**
	 * 
	 * @param code 商品ID
	 * @param name　　商品名
	 * @param price　原価
	 * @param salesPrice　売価
	 * @param stock　在庫
	 * @param type　種別
	 * @param note　備考
	 * @throws Exception
	 */
	public ExecuteLogic(int code,String name,String price,String salesPrice,String stock,String type,String note) throws Exception{
		
		ItemTableDAO exe = new ItemTableDAO(code ,name,price,salesPrice,stock,type,note);
	}

	
}
