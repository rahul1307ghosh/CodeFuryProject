package com.hsbc.entity;

public class AvailableAssetList {
	private int assetId;

	private String assetName;
	private String type;
	private String desc;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "AvailableAssetList [assetId=" + assetId + ", assetName=" + assetName + ", type=" + type + ", desc="
				+ desc + "]";
	}

}
