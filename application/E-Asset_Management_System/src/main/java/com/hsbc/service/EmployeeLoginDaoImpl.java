package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hsbc.entity.AssetCategory;
import com.hsbc.entity.DisplayAssetList;
import com.hsbc.entity.User;
import com.hsbc.util.DBUtil;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao {

	@Override
	public User employeeLogin(String id_choice, String uname_email) {

		List<DisplayAssetList> assetlist = null;
		int userID;

		String query = "select * from user where " + id_choice + " = \"" + uname_email + "\";";

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setTelphone(rs.getLong("telephone"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setPwd(rs.getString("password"));
				user.setLastLogin(rs.getString("lastLogin"));
				userID = rs.getInt("userId");
				assetlist = displayEmployeeAssets(userID);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<DisplayAssetList> displayEmployeeAssets(int userID) {

		String query = "SELECT assetAllocation.allocationId, asset.assetName, asset.type, asset.desciption, assetAllocation.allocation_date, assetAllocation.due_date, assetCategory.late_return_fee*DATEDIFF(CURDATE(),assetAllocation.due_date) As late_fee FROM user , assetAllocation, asset, assetCategory WHERE user.userId =assetAllocation.empId AND assetAllocation.assetId = asset.assetId AND assetCategory.category = asset.type AND user.userId="
				+ userID + ";";

		List<DisplayAssetList> displayAsset = new ArrayList<DisplayAssetList>();

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			while (rs.next()) {
				int fee;
				DisplayAssetList displayAssetList = new DisplayAssetList();
				displayAssetList.setAllocationId(rs.getInt("allocationId"));
				displayAssetList.setAssetName(rs.getString("assetName"));
				displayAssetList.setType(rs.getString("type"));
				displayAssetList.setDesciption(rs.getString("desciption"));
				displayAssetList.setAllocation_date(rs.getDate("allocation_date"));
				displayAssetList.setDue_date(rs.getDate("due_date"));
				if (rs.getInt("late_fee") < 0) {
					fee = 0;
				} else {
					fee = rs.getInt("late_fee");
				}
				displayAssetList.setLate_fee(fee);
				displayAsset.add(displayAssetList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return displayAsset;
	}

}
