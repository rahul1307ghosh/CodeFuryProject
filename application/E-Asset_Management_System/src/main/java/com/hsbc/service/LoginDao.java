package com.hsbc.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.entity.DisplayAssetList;
import com.hsbc.entity.EmployeeDisplayAsset;
import com.hsbc.entity.User;
import com.hsbc.util.DBUtil;
import com.hsbc.util.DateTimeUtil;
import com.hsbc.util.EncryptionPass;

public class LoginDao {
	public static EmployeeDisplayAsset login(String uname_email, String id_choice, String pwd) {
		String query = "";
		List<DisplayAssetList> assetlist = null;
		int userID;
		try {
			query = "select * from user where " + id_choice + " = \"" + uname_email + "\" and password =" + "\""
					+ EncryptionPass.toHexString(EncryptionPass.getSHA(pwd)) + "\"";

		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}

		System.out.println("query = " + query);

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			ResultSet rs = pst_1.executeQuery();

			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
				System.out.println("a = " + a);
			}
			if (a != 0) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setTelphone(rs.getLong("telephone"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setPwd("");
				user.setLastLogin(rs.getString("lastLogin"));
				userID = rs.getInt("userId");
				assetlist = displayEmployeeAssets(userID);
				EmployeeDisplayAsset empUser = new EmployeeDisplayAsset();
				empUser.setUser(user);
				empUser.setRole(getRole(id_choice, uname_email));
				empUser.setBorrowedAsset(assetlist);
				empUser.setPrevLogin(setLastLogin(id_choice, uname_email));
				System.out.println("Login Successfull");
				return empUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<DisplayAssetList> displayEmployeeAssets(int userID) {
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

	private static String getRole(String id_choice, String uname_email) {
		String role = "";
		String query = "select role from user where " + id_choice + " = \"" + uname_email + "\"";

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			if (rs.next()) {
				role = rs.getString(1);
				System.out.println(role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	private static String setLastLogin(String id_choice, String uname_email) {
		String prev_last_login = "";
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
		String query1 = "select lastlogin from user where " + id_choice + " = \"" + uname_email + "\"";
		String query2 = "Update user set lastlogin = \" " + DateTimeUtil.getCurrentDateTime() + " \" where " + id_choice
				+ " = \"" + uname_email + "\"";

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst_1 = conn.prepareStatement(query1);
			ResultSet rs = pst_1.executeQuery();

			if (rs.next()) {
				System.out.println("rs.getTimestamp(1) = " + rs.getTimestamp(1));
				prev_last_login = rs.getTimestamp(1).toString();
			}

			System.out.println(prev_last_login);

			PreparedStatement pst_2 = conn.prepareStatement(query2);

			System.out.println(query2);
			int count = pst_2.executeUpdate();

			if (count == 1) {
				System.out.println("last login datetime added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prev_last_login;
	}
}
