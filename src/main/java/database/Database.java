package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author yuta
 *データベースのもとになるクラス
 */
public abstract class Database {
	
	 protected final String url = "jdbc:mysql://localhost/ims?useSSL = false";
	 protected final String user = "root";
	 protected final String pass = "1013UmeAs5013TrueFalse";
	 
	 protected PreparedStatement pps;
	 protected ResultSet result;
	 
	 
	 protected String Sql;
	 
	 //テーブルに変更を加えるのは基本getConnection
	 public abstract void getConnection() throws Exception;
	 //テーブル内のデータを取得や確認するときはshowTable 
	 public abstract Object showTable() throws Exception;

	 
}
