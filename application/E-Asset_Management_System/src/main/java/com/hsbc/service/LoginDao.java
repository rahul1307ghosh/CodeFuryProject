package com.hsbc.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.entity.AvailableAssetList;
import com.hsbc.entity.DisplayAssetList;
import com.hsbc.entity.EmployeeDisplayAsset;
import com.hsbc.entity.Overdue;
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

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			ResultSet rs = pst_1.executeQuery();

			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
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
				empUser.setUserID(userID);

				return empUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<DisplayAssetList> displayEmployeeAssets(int userID) {
		String query = "SELECT assetAllocation.allocationId, asset.assetName, asset.type, asset.desciption, assetAllocation.allocation_date, assetAllocation.due_date, assetCategory.late_return_fee*DATEDIFF(CURDATE(),assetAllocation.due_date) As late_fee FROM user , assetAllocation, asset, assetCategory WHERE user.userId =assetAllocation.empId AND assetAllocation.assetId = asset.assetId AND assetCategory.category = asset.type AND user.userId="
				+ userID + ";";

		List<DisplayAssetList> displayAsset = new ArrayList<DisplayAssetList>();

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

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

			ResultSet rs = pst_1.executeQuery();

			if (rs.next()) {
				role = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	private static String setLastLogin(String id_choice, String uname_email) {
		String prev_last_login = "";

		String query1 = "select lastlogin from user where " + id_choice + " = \"" + uname_email + "\"";

		String query2 = "Update user set lastlogin = \" " + DateTimeUtil.getCurrentDateTime() + " \" where " + id_choice
				+ " = \"" + uname_email + "\"";

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst_1 = conn.prepareStatement(query1);
			ResultSet rs = pst_1.executeQuery();

			if (rs.next()) {
				prev_last_login = rs.getTimestamp(1).toString();
			}

			PreparedStatement pst_2 = conn.prepareStatement(query2);

			int count = pst_2.executeUpdate();

			if (count == 1) {
				System.out.println("last login datetime added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prev_last_login;
	}

	public static List<AvailableAssetList> DisplayAvailableAsset(int userId) {
		String query = "SELECT assetId, assetName, type, desciption from asset where isAvailable !=0 AND type NOT IN(SELECT distinct  asset.type from assetAllocation INNER JOIN asset ON assetAllocation.assetId= asset.assetId where assetallocation.empid="
				+ userId + ");";
		List<AvailableAssetList> availableAsset = new ArrayList<AvailableAssetList>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst_3 = conn.prepareStatement(query);

			ResultSet rs = pst_3.executeQuery();

			while (rs.next()) {

				AvailableAssetList assetList = new AvailableAssetList();
				assetList.setAssetId(rs.getInt("assetId"));
				assetList.setAssetName(rs.getString("assetName"));
				assetList.setType(rs.getString("type"));
				assetList.setDesc(rs.getString("desciption"));

				availableAsset.add(assetList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return availableAsset;
	}

	public static List<Overdue> showMessage(int userId) {
		String query = "select asset.assetId, asset.assetName, asset.type, asset.desciption, overdueasset.message  from asset, overdueasset where asset.assetId = overdueasset.assetid AND userid="
				+ userId + ";";
		List<Overdue> overdueMessageList = new ArrayList<Overdue>();
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst_1 = conn.prepareStatement(query);

			ResultSet rs = pst_1.executeQuery();

			while (rs.next()) {

				Overdue overdue = new Overdue();
				overdue.setAssetId(rs.getInt("assetId"));
				overdue.setAssetName(rs.getString("assetName"));
				overdue.setType(rs.getString("type"));
				overdue.setDesc(rs.getString("desciption"));
				overdue.setMessage(rs.getString("message"));

				overdueMessageList.add(overdue);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return overdueMessageList;

	}
}
