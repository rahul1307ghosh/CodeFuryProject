package com.hsbc.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.entity.AssetManagement;
import com.hsbc.entity.Overdue;
import com.hsbc.util.DBUtil;
import java.util.ArrayList;
import java.util.List;

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
				return response;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}

	public static List<Overdue> listAllAllocatedAssets() {
		List<Overdue> assetList = new ArrayList<Overdue>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId ");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new Overdue(rs.getString("name"), rs.getString("email"), rs.getString("assetName"),
						rs.getString("type"), rs.getInt("userId"), rs.getInt("assetId"), rs.getDate("due_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}

	public static List<Overdue> listAll() {
		List<Overdue> assetList = new ArrayList<Overdue>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId where assetAllocation.due_date < CURDATE();");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new Overdue(rs.getString("name"), rs.getString("email"), rs.getString("assetName"),
						rs.getString("type"), rs.getInt("userId"), rs.getInt("assetId"), rs.getDate("due_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}

	public static List<Overdue> listAllByName() {
		List<Overdue> assetList = new ArrayList<Overdue>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId where assetAllocation.due_date < CURDATE() order by user.name; ");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new Overdue(rs.getString("name"), rs.getString("email"), rs.getString("assetName"),
						rs.getString("type"), rs.getInt("userId"), rs.getInt("assetId"), rs.getDate("due_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}

	public static List<Overdue> listAllByDate() {
		List<Overdue> assetList = new ArrayList<Overdue>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.allocationId where assetAllocation.due_date < CURDATE() order by assetAllocation.due_date; ");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new Overdue(rs.getString("name"), rs.getString("email"), rs.getString("assetName"),
						rs.getString("type"), rs.getInt("userId"), rs.getInt("assetId"), rs.getDate("due_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}

	public static List<Overdue> listAllByCategory() {
		List<Overdue> assetList = new ArrayList<Overdue>();

		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement(
					"select user.name,user.email,asset.assetName,asset.type,user.userId,asset.assetId,assetAllocation.due_date from user inner join assetAllocation on user.userId=assetAllocation.empId inner join asset on asset.assetId=assetAllocation.assetId where assetAllocation.due_date < CURDATE() order by asset.type ");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				assetList.add(new Overdue(rs.getString("name"), rs.getString("email"), rs.getString("assetName"),
						rs.getString("type"), rs.getInt("userId"), rs.getInt("assetId"), rs.getDate("due_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return assetList;
	}
}
