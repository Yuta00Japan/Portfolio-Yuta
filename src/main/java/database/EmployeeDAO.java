package database;

import java.sql.Connection;
import java.sql.DriverManager;

import model.UserInfoBeans;

public class EmployeeDAO extends Database{
	
	//従業員の情報を取得するためのconstructor
	/**
	 * 
	 * @param code 従業員番号
	 */
	public EmployeeDAO(String code) {
	  this.Sql = 
		String.format("select emp.code,emp.name,post.post,dept.name,authority from employee as emp inner join department as dept on emp.deptcode = dept.code inner join postlist as post on emp.postcode = post.code where emp.code = %s;", code);
	}

	@Override
	public void getConnection() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Object showTable() throws Exception {

		   //戻り値として利用するインスタンスを準備
		   UserInfoBeans data = new UserInfoBeans();
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
			while(result.next()) {
				data.setCode(result.getInt("emp.code"));
				data.setName(result.getString("emp.name"));
				data.setPost(result.getString("post.post"));
				data.setDepartment(result.getString("dept.name"));
				data.setAuthority(result.getString("authority"));
			}
		}
		
		return data;
	}

   
}
