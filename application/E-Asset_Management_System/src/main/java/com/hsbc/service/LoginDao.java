package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.util.DBUtil;

public class LoginDao {
	public static String login(String uname_email, String id_choice, String pwd) {
		String resp = "Invalid Credentials";
		String emp_count = "select count(email) from user where " +id_choice+ " = \"" +uname_email+"\" and password =" + "\"" + pwd + "\"";
		System.out.println(emp_count);
		try {
			Connection conn = DBUtil.getConnConnection();
			
			PreparedStatement pst_1 = conn.prepareStatement(emp_count);

			System.out.println(emp_count);
			ResultSet rs = pst_1.executeQuery();
			
			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
			}
			if (a!=0) {
				resp = "Login Successfull";
				System.out.println("Login Successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
	}
}
