package com.hsbc.entity;

import java.time.LocalDate;
import java.util.Date;

public class DisplayAssetList {
	private int allocationId ;
	private String assetName ;
	private String type;
	private String desciption;
	private Date allocation_date;
	private Date due_date;
	private int late_fee;
	
	
	public Date getAllocation_date() {
		return allocation_date;
	}
	public void setAllocation_date(Date allocation_date) {
		this.allocation_date = allocation_date;
	}
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getLate_fee() {
		return late_fee;
	}
	public void setLate_fee(int late_fee) {
		this.late_fee = late_fee;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
