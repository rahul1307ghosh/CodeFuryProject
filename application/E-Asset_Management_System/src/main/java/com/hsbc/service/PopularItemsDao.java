package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.entity.Asset;
import com.hsbc.entity.DisplayAssetList;
import com.hsbc.util.DBUtil;

public class PopularItemsDao {
	public static List<Asset> getPopularAssets() {

		List<Asset> assetList = new ArrayList<>();
		String query = " select count(assetName) ,assetName,type from asset inner join assetAllocation on  asset.assetId=assetAllocation.assetId  group by assetName order by count(assetName) desc limit 3;";

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			int id = 1;
			while (rs.next()) {
				assetList.add(new Asset(rs.getString(2), rs.getString(3), "", String.valueOf(id++), rs.getInt(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}
}
