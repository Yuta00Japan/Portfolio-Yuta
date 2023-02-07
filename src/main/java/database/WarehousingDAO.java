package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.LogSearchResultBeans;

public class WarehousingDAO extends Database{
    //入庫内容を記録する
	
	public WarehousingDAO(String startDay,String endDay) {
		this.Sql = 
				String.format("select emp.name,itt.itemname,cost,price,quantity,dealtime,cl.name from warehousing as wh inner join employee as emp "
						+ " on wh.empcode = emp.code "
						+ " inner join itemtable as itt "
						+ " on wh.itemid = itt.itemid "
						+ " inner join clientlist as cl "
						+ " on wh.dealcode = cl.dealcode "
						+ " where dealtime between %s060000 and %s220000 order by dealtime;",startDay,endDay);
		System.out.println(this.Sql);
		
	}
	
	@Override
	public void getConnection() throws Exception {
		    
		
	}

	@Override
	public Object showTable() throws Exception {
		LogSearchResultBeans record = new LogSearchResultBeans();
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			while(result.next()) {
				record.setOfficer(result.getString("emp.name"));
				record.setItemName(result.getString("itt.itemname"));
				record.setCost(result.getInt("cost"));
				record.setPrice(result.getInt("price"));
				record.setQuantity(result.getInt("quantity"));
				record.setDealTime(result.getDate("dealtime"));
				record.setClient(result.getString("cl.name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return record;
	}

}
