package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.ClientBeans;

public class ClientListDAO extends Database{

	/**
	 * 取引先情報を簡易検索
	 * 
	 * @param dealCode　取引先番号
	 */
	public ClientListDAO(String dealCode) {
		this.Sql =
				String.format("select * from clientlist where dealcode = %s", dealCode);
		
	}
	
	@Override
	public void getConnection() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Object showTable() throws Exception {
	
		//取引先の情報を確認するBEANSです
		ClientBeans costomer = new ClientBeans();
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			while(result.next()) {
				costomer.setDealCode(result.getString("dealCode"));
				costomer.setClientName(result.getString("name"));
				costomer.setState(result.getString("state"));
				costomer.setAddress(result.getString("address"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(costomer.getClientName().isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
		
		return costomer;
	}

}
