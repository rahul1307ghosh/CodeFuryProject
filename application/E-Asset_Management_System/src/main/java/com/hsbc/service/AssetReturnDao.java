package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.entity.DisplayAssetList;
import com.hsbc.util.DBUtil;

public class AssetReturnDao {
	public static void saveReturnedAsset(int allocation_id, int empID) {
		String query = "SELECT assetAllocation.allocationId, asset.assetName, asset.type, asset.desciption, assetAllocation.allocation_date, assetAllocation.due_date, assetCategory.late_return_fee*DATEDIFF(CURDATE(),assetAllocation.due_date) As late_fee FROM user , assetAllocation, asset, assetCategory WHERE user.userId =assetAllocation.empId AND assetAllocation.assetId = asset.assetId AND assetCategory.category = asset.type AND user.userId="
				+ empID + " AND allocationId = "+allocation_id + ";";
		String query2 = "INSERT INTO historyassetAllocation values(?, ?, ?, ?, ?, ?, ?);";

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			while (rs.next()) {
				PreparedStatement pst_2 = conn.prepareStatement(query2);
				pst_2.setInt(1, rs.getInt("allocationId"));
				pst_2.setString(2, rs.getString("assetname"));
				pst_2.setString(3, rs.getString("type"));
				pst_2.setString(4, rs.getString("desciption"));
				pst_2.setInt(5, empID);
				pst_2.setDate(6,  rs.getDate("allocation_date"));
				pst_2.setDate(7, rs.getDate("due_date"));
				pst_2.executeUpdate();
			}

			
			System.out.println("empID before fetching = " + empID);
			
			System.out.println("allocation_id before fetching = " + allocation_id);
			
			String query3 = "select assetId from assetAllocation where empId ="+ empID+" AND allocationId="+allocation_id+";";
			PreparedStatement pst_3 = conn.prepareStatement(query3);
			
			System.out.println("query3 = " + query3);
			
			ResultSet rs1 = pst_3.executeQuery();
			int assetId = 0;
			if(rs1.next()) {
				assetId= rs1.getInt(1);
			}
			String query4 = "UPDATE asset SET isAvailable = 1 WHERE assetId=" +assetId+";";
			
			System.out.println("query4 = " + query4);
			
			PreparedStatement pst_4 = conn.prepareStatement(query4);
			pst_4.executeUpdate();
			
			DeleteReturnedAsset(allocation_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void DeleteReturnedAsset(int allocation_id) {
		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement("Delete from assetAllocation where allocationId = "+allocation_id+";");

			pst_1.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	}


