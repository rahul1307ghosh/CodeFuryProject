package com.hsbc.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.entity.Asset;
import com.hsbc.entity.AssetCategory;
import com.hsbc.util.DBUtil;
import java.util.ArrayList;
import java.util.List;

public class AssetDao {
	public static String save(Asset asset) {
		String response = "Asset already Exist";

		try {

			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"insert into asset (assetName,type,desciption,dateAdded,isAvailable) value(?,?,?,?,?)");

			pst.setString(1, asset.getAssetName());
			pst.setString(2, asset.getType());
			pst.setString(3, asset.getDescription());
			pst.setString(4, asset.getDateAdded());
			pst.setInt(5, asset.isAvailable());

			int count = pst.executeUpdate();
			if (count == 1) {
				response = "asset added";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}

	public List<AssetCategory> listAll() {
		List<AssetCategory> assetList = new ArrayList<AssetCategory>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select * from assetCategory;");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new AssetCategory(rs.getString("category"), rs.getInt("lending_period"),
						rs.getInt("late_return_fee"), rs.getString("days_banned")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assetList;
	}

}
