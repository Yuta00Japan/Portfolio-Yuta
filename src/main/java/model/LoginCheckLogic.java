package model;

import database.EmployeeDAO;
import database.PasswordTableDAO;

public class LoginCheckLogic {
	
	/**
	 * 
	 * @param empCode 従業員番号
	 * @param password　暗証番号
	 * @return　UserInfoBeans
	 * @throws Exception 
	 */
   public Object LoginLogic(String empCode,String password) throws Exception{
	   
		//社員番号とパスワードをもとに社員名を検索
		PasswordTableDAO checkData = new PasswordTableDAO(empCode,password);
		
		//戻り値として取得したインスタンスをダウンキャストし格納する。
		String empName = (String)checkData.showTable();           
		
		if(empName.equals(null)) {
			//名前が取得できていない場合はエラーを出す
			throw new IllegalArgumentException();
		}else {
			//取得できた場合　従業員番号から情報を取得　ー＞格納する
			EmployeeDAO emp = new EmployeeDAO(empCode);
			
			UserInfoBeans user = (UserInfoBeans)emp.showTable();
			
			return user;
		}
		
   }
}
