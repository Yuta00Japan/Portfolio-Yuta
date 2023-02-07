package model;

import database.DispatchingDAO;
import database.WarehousingDAO;

public class LogSearchLogic {
   
	/**
	 * ログを検索するロジックです
	 * 
	 * @param startDay　開始日
	 * @param endDay　終了日
	 * @param choise　ログ選択
	 * @return　ログ情報
	 * @throws Exception
	 */
	public Object LogSearch(String startDay,String endDay,String choise) throws Exception{
		
		//入庫の場合
		if(choise.equals("warehousing")) {
			
			WarehousingDAO search = new WarehousingDAO(startDay,endDay);
			
			LogSearchResultBeans result = (LogSearchResultBeans)search.showTable();
			
			return result;
		}else {
			//出庫の場合
			DispatchingDAO search = new DispatchingDAO(startDay,endDay);
		 
			LogSearchResultBeans result = (LogSearchResultBeans)search.showTable();
			
			return result;
		}
	}
}
