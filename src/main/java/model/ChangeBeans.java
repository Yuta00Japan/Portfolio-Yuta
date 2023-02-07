package model;

import java.io.Serializable;
import java.util.List;

public class ChangeBeans implements Serializable{
   //在庫の変更内容を格納するクラスです
	
	/**
	 * @itemId	商品名
	 * @quantity　数量
	 * @itemList　取引商品情報
	 * @method　操作内容
	 * @dealCode　取引先番号
	 * @dealName　取引先会社名
	 */
	private String[] itemId;
	
	private String[] quantity;
	
	private List<SearchResultBeans> itemList;
	
	private String[] method;
	
	private String[] dealCode;

	private String[] dealName;
	
	public ChangeBeans() {
		
		
	}
	
	public ChangeBeans(String[] itemId,String[] quantity,List<SearchResultBeans> itemList,String[] method,String[] dealCode) {
		setItemId(itemId);
		setQuantity(quantity);
		setItemList(itemList);
		setMethod(method);
		setDealCode(dealCode);
		
	}
	public String[] getItemId() {
		return itemId;
	}
	
	public void setItemId(String[] itemId) {
		this.itemId = itemId;
	}
	
	public String[] getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	
	public String[] getMethod() {
		return method;
	}
	
	public void setMethod(String[] method) {
		this.method = method;
	}
	
	public String[] getDealCode() {
		return dealCode;
	}
	
	public void setDealCode(String[] dealCode) {
		this.dealCode = dealCode;
	}
	
	public String[] getDealName() {
		return dealName;
	}
	
	public void setDealName(String[] dealName) {
		this.dealName = dealName;
	}
	
	public List<SearchResultBeans> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<SearchResultBeans> itemList) {
		this.itemList = itemList;
	}

	
	
}
