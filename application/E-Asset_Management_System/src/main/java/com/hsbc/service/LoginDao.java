package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hsbc.entity.User;
import com.hsbc.util.DBUtil;

public class LoginDao {
	public static String login(String uname_email, String id_choice, String pwd) {
		String resp = "Invalid Credentials";
		String query = "select count(email) from user where " + id_choice + " = \"" + uname_email + "\" and password ="
				+ "\"" + pwd + "\"";
		System.out.println(query);
		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();

			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
			}
			if (a != 0) {
				resp = getRole(id_choice, uname_email);
				setLastLogin(id_choice, uname_email);
				System.out.println("Login Successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
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

	private static void setLastLogin(String id_choice, String uname_email) {
		String role = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String query = "Update user set lastlogin = \" "+ dtf.format(now) + " \" where " + id_choice + " = \"" + uname_email + "\"";

		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			int count = pst_1.executeUpdate();

			if (count == 1) {
				System.out.println("last login datetime added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static User getUserDetails(String id_choice, String uname_email) {
		String query = "Select * from user where " + id_choice + " = \"" + uname_email + "\"";
		User user;
		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(query);

			System.out.println(query);
			ResultSet rs = pst_1.executeQuery();
			
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5) , "", rs.getDate(7).toString());
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
