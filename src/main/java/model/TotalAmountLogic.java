package model;

import java.util.ArrayList;
import java.util.List;

public class TotalAmountLogic {

	/**
	 * 原価価格で入庫金額を計算するmethod
	 * @param item　商品情報
	 * @param quantity　数量
	 * @param method　操作内容
	 * @return　入庫金額（原価）
	 */
	public int warehousingAmount(List<SearchResultBeans> item,String[] quantity, String method[]) {
		
		int warehousingSum = 0;
		
		//数値化
		ArrayList<Integer>quantityNum = new ArrayList<>();
		
		for(int i = 0; i < quantity.length; i++) {
			quantityNum.add(Integer.parseInt(quantity[i]));
		}
		
		//入庫額計算
		for(int i = 0; i < item.size(); i++) {
			
			SearchResultBeans items = item.get(i);
			
			int cost = items.getItemPrice().get(0);
			
			if(method[i].equals("storage")) {
				
				warehousingSum += cost * quantityNum.get(i);
			}
		}
		
		return warehousingSum;
	}
	/**
	 * 原価価格で出庫金額を計算するロジックです。
	 * @param item　商品情報
	 * @param quantity　数量
	 * @param method　操作内容
	 * @return　出庫金額（原価）
	 */
	public int dispatchingSum(List<SearchResultBeans> item,String[] quantity,String[]method) {
		
		int dispatchingSum = 0;
		
		ArrayList<Integer>quantityNum = new ArrayList<>();
		
		//数値化
		for(int i = 0; i < quantity.length; i++) {
			quantityNum.add(Integer.parseInt(quantity[i]));
		}
		
		
		for(int i = 0; i < item.size(); i++) {
			
			SearchResultBeans items = item.get(i);
			
			int cost = items.getItemPrice().get(0);
			
			if(method[i].equals("withdrawal")) {
				
				dispatchingSum += cost * quantityNum.get(i);
			}
		}
		
		return dispatchingSum;
	}
}
