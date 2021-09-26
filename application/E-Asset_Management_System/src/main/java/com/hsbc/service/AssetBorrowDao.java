package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.util.DBUtil;

public class AssetBorrowDao {

	public static void borrowAsset(int assetId, int userId) {
		int period = 0;
		String query = "SELECT assetCategory.lending_period FROM asset, assetCategory WHERE asset.type = assetCategory.category AND asset.assetId="
				+ assetId + ";";

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst_1 = conn.prepareStatement(query);
			ResultSet rs = pst_1.executeQuery();
			if (rs.next()) {
				period = rs.getInt("lending_period");
			}

			String insertQuery = "Insert into assetAllocation(assetId,empId,allocation_date,due_date) values(" + assetId
					+ ", " + userId + " ," + "CURDATE(), DATE_ADD(CURDATE(), INTERVAL " + period + " DAY));";
			PreparedStatement pst_2 = conn.prepareStatement(insertQuery);

			pst_2.executeUpdate();

			String query2 = "UPDATE asset SET isAvailable = 0 WHERE assetId=" + assetId + ";";
			PreparedStatement pst_3 = conn.prepareStatement(query2);
			pst_3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
