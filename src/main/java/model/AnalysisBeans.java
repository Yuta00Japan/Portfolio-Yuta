package model;

import java.io.Serializable;

public class AnalysisBeans implements Serializable{

	/**
	 * @cost　原価
	 * @sales　売価
	 * @benefit　粗利
	 */
	private int cost;
	
	private int sales;
	
	private int benefit;
	
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

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

}
