package com.hsbc.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import com.hsbc.entity.AssetManagement;
import com.hsbc.entity.overdue;
import com.hsbc.util.DBUtil;
import java.text.ParseException;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;  
public class AssetOverdueMangDao {
	public static String save(AssetManagement OverDueAsset) {
		String response = " Message Not Sent!";
		
		try {

			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn
						.prepareStatement("insert into OverDueAsset (userId,assetId,message) value(?,?,?)");

				pst.setInt(1, OverDueAsset.getUserId());
				pst.setInt(2, OverDueAsset.getAssetId());
				pst.setString(3, OverDueAsset.getMessage());
			

				int count = pst.executeUpdate();
				if (count == 1) {
					response = "Message Sent!";
					System.out.println(response);
					return response;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}
	public static List<overdue> listAll() {
		List<overdue> assetList= new ArrayList<overdue>();
		
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId");
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				assetList.add(new overdue(rs.getString("name"),rs.getString("email"),rs.getString("assetName"),rs.getString("type"),rs.getInt("userId"),rs.getInt("assetId"),rs.getDate("due_date")));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(assetList);
		return assetList;
	}
	public static List<overdue> listAllByName() {
		List<overdue> assetList= new ArrayList<overdue>();
		
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId  order by user.name; ");
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				assetList.add(new overdue(rs.getString("name"),rs.getString("email"),rs.getString("assetName"),rs.getString("type"),rs.getInt("userId"),rs.getInt("assetId"),rs.getDate("due_date")));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(assetList);
		return assetList;
	}
	public static List<overdue> listAllByDate() {
		List<overdue> assetList= new ArrayList<overdue>();
		
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.allocationId  order by assetAllocation.due_date; ");
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				assetList.add(new overdue(rs.getString("name"),rs.getString("email"),rs.getString("assetName"),rs.getString("type"),rs.getInt("userId"),rs.getInt("assetId"),rs.getDate("due_date")));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(assetList);
		return assetList;
	}
	public static List<overdue> listAllByCategory() {
		List<overdue> assetList= new ArrayList<overdue>();
		
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId  order by asset.type ");
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				assetList.add(new overdue(rs.getString("name"),rs.getString("email"),rs.getString("assetName"),rs.getString("type"),rs.getInt("userId"),rs.getInt("assetId"),rs.getDate("due_date")));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(assetList);
		return assetList;
	}
}
