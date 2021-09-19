package com.hsbc.entity;

import java.util.Date;

public class Asset {
   private String assetName;
   private String type;
   private String description;

public Asset(String assetName, String type, String description) {
	super();
	this.assetName = assetName;
	this.type = type;
	this.description = description;

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


}
