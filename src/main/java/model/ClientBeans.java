package model;

import java.util.ArrayList;

public class ClientBeans {
   
	//取引先の情報を格納するクラスです。
	
	/*
	 * @dealCode 取引先番号 
	 * @clientName　取引先会社名
	 * @state　都道府県
	 * @address　所在地
	 */
	private ArrayList<String>  dealCode = new ArrayList<>();
	private ArrayList<String> clientName = new ArrayList<>();
	private ArrayList<String> state = new ArrayList<>();
	private ArrayList<String> address = new ArrayList<>();
	
	public ClientBeans() {
		
	}

	public ArrayList<String> getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName.add(clientName);
	}

	public ArrayList<String> getState() {
		return state;
	}

	public void setState(String state) {
		this.state.add(state);
	}

	public ArrayList<String> getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address.add(address);
	}

	public ArrayList<String> getDealCode() {
		return dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode.add(dealCode);
	}
}
