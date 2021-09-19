package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hsbc.entity.Asset;
import com.hsbc.entity.AssetCategory;
import com.hsbc.util.DBUtil;

public class AssetCategoryDao {
	public static String save(AssetCategory assetCategory) {
		String response = "Asset already Exist";
		System.out.println();
		try {
			
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn
						.prepareStatement("insert into assetCategory value(?,?,?,?)");

				pst.setString(1,assetCategory.getCategory());
				pst.setInt(2,assetCategory.getLending_period());
				pst.setInt(3,assetCategory.getLate_return_fee());
				pst.setString(4,assetCategory.getDays_banned());

				int count = pst.executeUpdate();
				if (count == 1) {
					response = "asset Category added";
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}
}
