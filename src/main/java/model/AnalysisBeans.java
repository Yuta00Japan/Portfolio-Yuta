package model;

import java.io.Serializable;

public class AnalysisBeans implements Serializable{

	/**
	 * @cost　原価
	 * @sales　売価
	 */
	private int cost;
	
	private int sales;
	
	public AnalysisBeans() {
		
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}


}
