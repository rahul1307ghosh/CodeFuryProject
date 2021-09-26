package com.hsbc.entity;

public class Asset {
	private String assetName;
	private String type;
	private String description;
	private String dateAdded;
	private int isAvailable;

	public Asset(String assetName, String type, String description, String string, int i) {
		super();
		this.assetName = assetName;
		this.type = type;
		this.description = description;
		this.dateAdded = string;
		this.isAvailable = i;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int isAvailable() {
		return isAvailable;
	}

	public void setAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

}
