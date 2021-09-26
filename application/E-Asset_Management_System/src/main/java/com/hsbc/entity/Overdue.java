package com.hsbc.entity;

import java.util.Date;

public class Overdue {

	private String userName;
	private String email;
	private String assetName;
	private String category;
	private int userId;
	private int assetId;
	private Date due_date;

	public Overdue(String userName, String email, String assetName, String category, int userId, int assetId,
			Date due_date) {
		super();
		this.userName = userName;
		this.email = email;
		this.assetName = assetName;
		this.category = category;
		this.userId = userId;
		this.assetId = assetId;
		this.due_date = due_date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	private String type;
	private String desc;
	private String message;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Overdue() {

	}
}
