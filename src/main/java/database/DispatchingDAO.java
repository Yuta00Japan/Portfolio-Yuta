package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.LogSearchResultBeans;

public class DispatchingDAO extends Database{
    //出庫内容を記録するクラスです。
	
	/**
	 * ログを閲覧するためのconstructorです。
	 * @param startDay　開始日
	 * @param endDay　終了日
	 */
	public DispatchingDAO(String startDay,String endDay) {
		this.Sql =
				String.format("select emp.name,itt.itemname,cost,price,quantity,dealtime,cl.name from dispatching as dis inner join employee as emp"
						+ " on dis.empcode = emp.code "
						+ " inner join itemtable as itt "
						+ " on dis.itemid = itt.itemid "
						+ " inner join clientlist as cl "
						+ " on dis.dealcode = cl.dealcode "
						+ " where dealtime between %s060000 and %s220000;",startDay,endDay);
		System.out.println(this.Sql);
	}
	
	
	@Override
	public void getConnection() throws Exception {
		
	}

	@Override
	public Object showTable() throws Exception {

		LogSearchResultBeans lsrb = new LogSearchResultBeans();
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			while(result.next()) {
				lsrb.setOfficer(result.getString("emp.name"));
				lsrb.setItemName(result.getString("itt.itemname"));
				lsrb.setCost(result.getInt("cost"));
				lsrb.setPrice(result.getInt("price"));
				lsrb.setQuantity(result.getInt("quantity"));
				lsrb.setDealTime(result.getDate("dealtime"));
				lsrb.setClient(result.getString("cl.name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lsrb;
	}
       
}
