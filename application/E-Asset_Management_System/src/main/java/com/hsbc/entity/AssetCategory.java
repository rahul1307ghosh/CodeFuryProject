package com.hsbc.entity;

public class AssetCategory {

	private String category;
	private int lending_period ;
	private int late_return_fee ;
	private String days_banned;
	public AssetCategory(String category, int lending_period, int late_return_fee, String days_banned) {
		super();
		this.category = category;
		this.lending_period = lending_period;
		this.late_return_fee = late_return_fee;
		this.days_banned = days_banned;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLending_period() {
		return lending_period;
	}
	public void setLending_period(int lending_period) {
		this.lending_period = lending_period;
	}
	public int getLate_return_fee() {
		return late_return_fee;
	}
	public void setLate_return_fee(int late_return_fee) {
		this.late_return_fee = late_return_fee;
	}
	public String getDays_banned() {
		return days_banned;
	}
	public void setDays_banned(String days_banned) {
		this.days_banned = days_banned;
	}
}
