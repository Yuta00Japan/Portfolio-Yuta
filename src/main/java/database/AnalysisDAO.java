package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.AnalysisBeans;

public class AnalysisDAO extends Database{
	
	//売り上げ額 仕入額計算　利益計算
	/**
	 * 出庫ログより計算
	 * 
	 */
	public AnalysisDAO(String startday,String endday) {
		this.Sql =String.format("select (select sum(quantity*cost) from warehousing where dealtime between %s060000 and %s220000) as cost,"
				+ " (select sum(quantity*price)from warehousing where dealtime between %s060000 and %s220000) as sales, "
				+ "	((select sum(quantity*price)from warehousing where dealtime between %s060000 and %s220000)-"
				+ " (select sum(quantity*cost) from warehousing where dealtime between %s060000 and %s220000))as benefit;"
				+ " ",startday,endday,startday,endday,startday,endday,startday,endday);
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
			   ana.setSales(result.getInt("sales"));
			   ana.setBenefit(result.getInt("benefit"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return ana;
	}

}
