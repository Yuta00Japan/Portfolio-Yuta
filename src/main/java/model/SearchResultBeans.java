package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品の検索結果を格納するBEANSです。
 * @author yuta
 *
 */
public class SearchResultBeans implements Serializable{
 
	/**
	 * @itemCode 商品ID
	 * @itemName　商品名
	 * @itemType　商品種別
	 * @itemStock　在庫
	 * @itemPrice　商品原価
	 * @salesPrice　売価
	 * @itemNote　備考
	 */
	private List<Integer> itemCode = new ArrayList<>();
	
	private List<String> itemName = new ArrayList<>();
	
	private List<String> itemType = new ArrayList<>();
	
	private List<Integer> itemStock = new ArrayList<>();
	/*仕入価格*/
	private List<Integer> itemPrice = new ArrayList<>();
	/*販売価格*/
	private List<Integer> salesPrice = new ArrayList<>();
	
	private List<String> itemNote = new ArrayList<>();
	
	public SearchResultBeans() {
		
	}

	public List<Integer> getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode.add(itemCode);
	}

	public List<String> getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName.add(itemName);
	}

	public List<String> getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType.add(itemType);
	}

	public List<Integer> getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock.add(itemStock);
	}

	public List<Integer> getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice.add(itemPrice);
	}

	public List<String> getItemNote() {
		return itemNote;
	}

	public void setItemNote(String itemNote) {
		this.itemNote.add(itemNote);
	}

	public List<Integer> getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice.add(salesPrice);
	}
	
 }
