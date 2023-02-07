package model;

import java.io.Serializable;

public class InsertBeans implements Serializable{
      
	/**
	 * @itemName 商品名
	 * @price　原価
	 * @salesPrice　売価
	 * @stock　在庫
	 * @type　種別
	 * @note　備考
	 */
	private String itemName;
	private String price;
	private String salesPrice;
	private String stock;
	private String type;
	private String note;
	
	public InsertBeans() {
		
	}
	
	public InsertBeans(String itemName,String price,String salesPrice,String stock,String type,String note) {
		setItemName(itemName);
		setPrice(price);
		setStock(stock);
		setSalesPrice(salesPrice);
		setType(type);
		setNote(note);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	public String getSalesPrice() {
		return salesPrice;
	}
	
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	
}
