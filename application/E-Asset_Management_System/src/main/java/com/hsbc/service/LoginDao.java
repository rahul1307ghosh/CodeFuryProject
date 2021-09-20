package com.hsbc.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hsbc.util.DBUtil;
import com.hsbc.util.EncryptionPass;

public class LoginDao {
	public static String login(String uname_email, String id_choice, String pwd) {
		String resp = "Invalid Credentials";
		String query = "";
		try {
			query = "select count(email) from user where " + id_choice + " = \"" + uname_email + "\" and password ="
					+ "\"" + EncryptionPass.toHexString(EncryptionPass.getSHA(pwd)) + "\"";
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
}
