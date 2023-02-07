package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class PasswordTableDAO extends Database{

	/**
	 * 
	 * @param empCode　従業員番号
	 * @param pass　パスワード
	 */
    public PasswordTableDAO(String empCode,String pass) {
        this.Sql = 
          String.format("select emp.name from employee as emp inner join passwordtable as pass"
          		+ " on emp.code = pass.empcode "
          		+ " where emp.code = %s and pass.password = '%s'", empCode,pass);
        System.out.println(this.Sql);
    }
	
	@Override
	public void getConnection() throws Exception {
		
	}

	@Override
	/**
	 * String judgeに従業員名が返ってくれば
	 * ログイン成功とみなす。
	 */
	public Object showTable() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
		String judge = null;
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			while(result.next()) {
				 judge = result.getString("emp.name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return judge;
	}

	

}
