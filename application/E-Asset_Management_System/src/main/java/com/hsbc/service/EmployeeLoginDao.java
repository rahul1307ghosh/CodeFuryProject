package com.hsbc.service;

import java.util.List;

import com.hsbc.entity.DisplayAssetList;
import com.hsbc.entity.User;

public interface EmployeeLoginDao {
	public User employeeLogin(String id_choice, String uname_email);
	public List<DisplayAssetList> displayEmployeeAssets(int userID);	
	

}
