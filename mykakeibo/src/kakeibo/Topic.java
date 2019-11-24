package kakeibo;

import java.util.Date;

public class Topic { // Temporary name

/*
 * 入力項目
 * ジャンル(食べ物、本、光熱費等、その他)←ウィザード形式で表示
 * 名前(手動入力)
 * 金額(手動入力)
 */
	// ジャンル(食べ物、本、光熱費等、その他)
	private String genre;
	//名前(手動入力)
	private String prname;
	//金額(手動入力)
	private String prcost;
	//購入日時
	private Date pdate;
	//出費合計(variable)
	private String totalVariableCost;
	//出費合計(固定費)
	private String totalFixedCost;
	//月別食費合計
	private String monthlyFoodCost;
	//月別書籍費合計
	private String monthlyBookCost;
	//月別光熱費合計
	private String monthlyUtilityCost;
	//月別その他費用合計
	private String monthlyElseCost;
	/*
	 * 固定費の定義
	 */
	//固定費の名前
	private String fx_name;
	//固定費
	private String fx_cost;
	//固定費の合計
	private String totalFxCost;

	public String toString() {
		return super.toString()
				+ ",genre=" + genre
				+ ",prname=" + prname
				+ ",prcost=" + prcost
				+ ",pdate=" + pdate
				+ ",totalVariableCost" + totalVariableCost
				+ ",totalFixedCost" + totalFixedCost
				+ ",monthlyFoodCost" + monthlyFoodCost
				+ ",monthlyBookCost" + monthlyBookCost
				+ ",monthlyUtilityCost" + monthlyUtilityCost
				+ ",monthlyElseCost" + monthlyElseCost
				+ ",fx_name" + fx_name
				+ ",fx_cost" + fx_cost
				+ ",totalFxCost" + totalFxCost
				;
	}

	//
	// SETTER, GETTER
	//
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public String getPrcost() {
		return prcost;
	}
	public void setPrcost(String prcost) {
		this.prcost = prcost;
	}
	public Date getPdate() {
		return this.pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}


	// Get&Set Variable costs Attribution
	public String getTotalVariableCost() {
		return this.totalVariableCost;
	}
	public void setTotalVariableCost(String totalVariableCost) {
		this.totalVariableCost = totalVariableCost;
	}
	public String getMonthlyFoodCost() {
		return this.monthlyFoodCost;
	}
	public void setMonthlyFoodCost(String monthlyFoodCost) {
		this.monthlyFoodCost = monthlyFoodCost;
	}
	public String getMonthlyBookCost() {
		return this.monthlyBookCost;
	}
	public void setMonthlyBookCost(String monthlyBookCost) {
		this.monthlyBookCost = monthlyBookCost;
	}
	public String getMonthlyUtilityCost() {
		return this.monthlyUtilityCost;
	}
	public void setMonthlyUtilityCost(String monthlyUtilityCost) {
		this.monthlyUtilityCost = monthlyUtilityCost;
	}
	public String getMonthlyElseCost() {
		return this.monthlyElseCost;
	}
	public void setMonthlyElseCost(String monthlyElseCost) {
		this.monthlyElseCost = monthlyElseCost;
	}

	//GET&SET Fixed Name&Cost

	public String getFxName() {
		return this.fx_name;
	}
	public void setFxName(String fx_name) {
		this.fx_name = fx_name;
	}
	public String getFxCost() {
		return this.fx_cost;
	}
	public void setFxCost(String fx_cost) {
		this.fx_cost = fx_cost;
	}
	public String getTotalFxCost() {
		return this.totalFxCost;
	}
	public void setTotalFxCost(String totalFxCost) {
		this.totalFxCost = totalFxCost;
	}
}
