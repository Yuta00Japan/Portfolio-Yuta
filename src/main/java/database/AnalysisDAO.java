package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.AnalysisBeans;

public class AnalysisDAO extends Database{
	
	//売り上げ額合計 売上原価合計　粗利合計
	/**
	 * 出庫ログより計算
	 * 
	 */
	public AnalysisDAO(String startday,String endday) {
		this.Sql =String.format("select sum(quantity*cost) as cost,sum(quantity*price) as price "
				+ " from dispatching"
				+ " where dealtime between %s and %s",startday,endday);
		System.out.println(this.Sql);
	}
	
	
	

	@Override
	public void getConnection() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Object showTable() throws Exception {
		
		AnalysisBeans ana = new AnalysisBeans();
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			
			while(result.next()) {
			   ana.setCost(result.getInt("cost"));
			   ana.setSales(result.getInt("price"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return ana;
	}

}
