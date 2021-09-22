package com.hsbc.entity;

public class AssetManagement {

		private int userId;
		private int assetId;
		private String message;
	
		public AssetManagement() {

		}
		
		
		public AssetManagement(int userId, int assetId, String message) {
			super();
			this.userId = userId;
			this.assetId = assetId;
			this.message = message;
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


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		
		
}
