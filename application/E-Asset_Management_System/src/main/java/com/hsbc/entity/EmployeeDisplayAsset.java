package com.hsbc.entity;

import java.util.List;

public class EmployeeDisplayAsset {
	private User user;
	private String role;
	private List<DisplayAssetList> borrowedAsset;
	private String prevLogin;

	public String getPrevLogin() {
		return prevLogin;
	}

	public void setPrevLogin(String prevLogin) {
		this.prevLogin = prevLogin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<DisplayAssetList> getBorrowedAsset() {
		return borrowedAsset;
	}

	public void setBorrowedAsset(List<DisplayAssetList> borrowedAsset) {
		this.borrowedAsset = borrowedAsset;
	}

	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
