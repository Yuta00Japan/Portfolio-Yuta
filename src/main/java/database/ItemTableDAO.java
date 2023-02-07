package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import model.ChangeBeans;
import model.SearchResultBeans;
import model.UserInfoBeans;

public class ItemTableDAO extends Database{
	
	/**
	 * 全商品を検索するconstructor
	 * 
	 */
	public ItemTableDAO() {
		this.Sql ="select * from itemtable";
	}
	
	/**
	 * 商品を簡易的に検索するためのものです
	 * @param itemId 商品番号
	 */
	public ItemTableDAO(String itemId) {
		this.Sql =
			String.format("select * from itemtable where itemid = %s", itemId);
	}
	/**
	 * 在庫を出し入れするconstructorです
	 * @param user 担当者の情報
	 * @param ch　在庫操作内容
	 * @throws Exception
	 * 
	 * delimiter //
	 * プロシージャの内容　左から順に
	 * 　　　　　　　　　数量　原価　売価　商品番号　操作内容　従業員番号　取引先番号　
	create procedure turnover (quantity int, cost int,price int,itemids int,turnover varchar(15),empcode int,dealcode int)
	begin
 	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
  	BEGIN
    	GET DIAGNOSTICS CONDITION 1 @sqlstate = RETURNED_SQLSTATE, @errno = MYSQL_ERRNO, @text = MESSAGE_TEXT;
    	SELECT @sqlstate, @errno, @text;
    	ROLLBACK;
  	END;
	start transaction;
	if turnover = 'storage' then
		update itemtable set itemstock= itemstock + quantity where itemid = itemids;
		insert into warehousing values(empcode,itemids,cost,price,quantity,now(),dealcode);
		commit;
	else
		update itemtable set itemstock = itemstock - quantity where itemid = itemids;
		insert into dispatching values(empcode,itemids,cost,price,quantity,now(),dealcode);
		commit;
	end if;
	end //
	*/
	public ItemTableDAO(UserInfoBeans user,ChangeBeans ch) throws Exception{
		
		List<SearchResultBeans>itemList = ch.getItemList();
		//複数の商品取引に対応するためのもの
		
		String[]itemId = ch.getItemId();
		
		String[]quantity = ch.getQuantity();
		
		String[]method = ch.getMethod();
		
		String[]dealCode = ch.getDealCode();
		
		//取引回数分繰り返し
		for(int i = 0; i < itemList.size(); i++) {
		
			SearchResultBeans item = itemList.get(i);
			
		this.Sql =
		  String.format
		  ("call turnover(%s,%d,%d,%s,'%s',%d,%s)",quantity[i],item.getItemPrice().get(0),item.getSalesPrice().get(0),itemId[i],method[i],user.getCode(),dealCode[i]);
			System.out.println(this.Sql);
			getConnection();
		}
	}
	/**
	 * 詳細検索をする際に使用します
	 * @param name 商品名
	 * @param exception　
	 * @param startPrice　価格帯指定始め
	 * @param endPrice　価格帯指定終わり
	 */
	public ItemTableDAO(String name,String exception,String startPrice,String endPrice) {
		this.Sql =
			String.format("select * from itemtable "
					 				+"where itemname like "+"'%%"+"%s"+"%%' "
					 				+ "and itemname not like "+"'%%"+"%s"+"%%' "
									+ "and itemprice between %s and %s ",name,exception,startPrice,endPrice);
		System.out.println(this.Sql);
	}
	//新商品を追加する際のconstructor
	/**
	 * 
	 * @param name 商品名
	 * @param price　仕入れ価格
	 * @param salesPrice　販売価格
	 * @param stock　在庫
	 * @param type　商品種別
	 * @param note　商品備考欄
	 * @throws Exception
	 * 
	 */
	public ItemTableDAO(String name,String price,String salesPrice,String stock,String type,String note) throws Exception {
		
		this.Sql=
			String.format("insert into itemtable(itemname,itemprice,salesprice,itemstock,itemtype,itemnote) values"
					+ " ('%s',%s,%s,%s,%s,'%s')", name,price,salesPrice,stock,type,note);
		
		System.out.println(this.Sql);
		getConnection();
	}
	//商品を修正するためのconstructor
	/**
	 * 
	 * @param code 商品ID
	 * @param name　商品名
	 * @param price　仕入価格
	 * @param salesPrice　販売価格
	 * @param stock　商品在庫
	 * @param type　商品種別
	 * @param note　商品備考欄
	 * @throws Exception
	 * 
	 * 
	 */
	public ItemTableDAO(int code,String name,String price,String salesPrice,String stock,String type,String note) throws Exception {
		
		this.Sql =
			String.format("update itemtable set itemname = '%s',itemprice = %s, salesprice = %s, "
					+ " itemstock = %s ,itemtype =%s, itemnote ='%s' where itemid = %s;",name,price,salesPrice,stock,type,note,code);
		System.out.println(this.Sql);
		getConnection();
	}
	
	@Override
	public void getConnection() throws Exception {
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			pps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Object showTable() throws Exception {

		SearchResultBeans data = new SearchResultBeans();
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			pps = con.prepareStatement(this.Sql);
			result = pps.executeQuery();
				while(result.next()) {
					data.setItemCode(result.getInt("itemid"));
					data.setItemName(result.getString("itemname"));
					data.setItemPrice(result.getInt("itemprice"));
					data.setSalesPrice(result.getInt("salesprice"));
					data.setItemStock(result.getInt("itemstock"));
					data.setItemType(result.getString("itemtype"));
					data.setItemNote(result.getString("itemnote"));
				}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(data.getItemName().isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
		
		
		return data;
	}

}
