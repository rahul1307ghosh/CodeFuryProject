package com.hsbc.exception;

public class AssetCategoryAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public AssetCategoryAlreadyExistException() {
	}

	public AssetCategoryAlreadyExistException(String message) {
		super(message);
	}

}
