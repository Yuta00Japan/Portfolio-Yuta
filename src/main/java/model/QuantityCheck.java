package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 在庫から引き出す際、引き出し量が在庫を上回っていないか確認します
 * @author yuta
 *
 */
public class QuantityCheck {
   
	/**
	 * 
	 * @param itemList 商品の情報を複数含んだLIST
	 * @param turnovers　引き出し量OR預入量
	 * @param method　出し入れ
	 * @throws Exception
	 */
	public QuantityCheck(List<SearchResultBeans> itemList ,String[] turnovers,String[] method) throws Exception{
		
		System.out.println("turnovers"+ turnovers.length);
		//数値化
		ArrayList<Integer> turnoverNum = new ArrayList<>();
		
		for(int i = 0; i < turnovers.length;i++) {
			turnoverNum.add(Integer.parseInt(turnovers[i]));
		}
		
		System.out.println("要素数"+itemList.size()+" "+turnovers.length+" "+method.length);
		
		//引き出し量チェック
		for(int i = 0; i < itemList.size(); i++) {
			
			SearchResultBeans item = itemList.get(i);
			
			int currentStock = item.getItemStock().get(0);
			
			if(method[i].equals("storage")) {
				
				System.out.println("現在の在庫"+currentStock+" "+"収納量"+turnoverNum.get(i));
			}else {
				
				//万が一マイナスの値が入力されたら
				if(turnoverNum.get(i) < 0) {
					throw new IllegalArgumentException();
				}
				System.out.println("現在の在庫"+currentStock+" "+"引き出し量"+turnoverNum.get(i));
				
				//引出量が現在の在庫を上回った場合は例外を投げる
				if(currentStock < turnoverNum.get(i)) {
					throw new IllegalArgumentException();
				}
			}
		}
	}
}
