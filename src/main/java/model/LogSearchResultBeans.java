package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class LogSearchResultBeans implements Serializable{
     
	/**
	 * @officer　従業員名
	 * @itemName　商品名
	 * @cost　原価
	 * @price　売価
	 * @quantity　数量
	 * @dealTime　取引日時
	 * @client　顧客番号
	 */
	private ArrayList<String>officer = new ArrayList<>();
	
	private ArrayList<String> itemName = new ArrayList<>();
	
	private ArrayList<Integer>cost = new ArrayList<>();
	
	private ArrayList<Integer>price = new ArrayList<>();
	
	private ArrayList<Integer>quantity = new ArrayList<>();
	
	private ArrayList<Date>dealTime = new ArrayList<>();
	
	private ArrayList<String>client = new ArrayList<>();
	
	public LogSearchResultBeans() {
		
	}

	public ArrayList<String> getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer.add(officer);
	}

	public ArrayList<String> getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName.add(itemName);
	}

	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity.add(quantity);
	}

	public ArrayList<Date> getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime.add(dealTime);
	}

	public ArrayList<String> getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client.add(client);
	}

	public ArrayList<Integer> getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost.add(cost);
	}

	public ArrayList<Integer> getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price.add(price);
	}
}
