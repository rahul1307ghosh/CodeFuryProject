package com.hsbc.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hsbc.entity.Asset;
import com.hsbc.entity.AssetCategory;
import com.hsbc.util.DBUtil;
import java.text.ParseException;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;  
public class AssetDao {
	public static String save(Asset asset) {
		String response = "Asset already Exist";
		System.out.println();
		try {
			

			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn
						.prepareStatement("insert into asset (assetName,type,desciption,dateAdded,isAvailable) value(?,?,?,?,?)");

				pst.setString(1, asset.getAssetName());
				pst.setString(2, asset.getType());
				pst.setString(3, asset.getDescription());
				pst.setString(4, asset.getDateAdded());
				pst.setInt(5,asset.isAvailable());

				int count = pst.executeUpdate();
				if (count == 1) {
					response = "asset added";
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}
	
}
