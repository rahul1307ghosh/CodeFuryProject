package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.entity.User;
import com.hsbc.util.DBUtil;

public class RegisterDao {
	
	public static String save(User user) {
		String response = "User already exists";
		String emp_count = "select count(email) from user where email= \"" +user.getEmail()+"\";";
		System.out.println();
		try {
			Connection conn = DBUtil.getConnConnection();

			PreparedStatement pst_1 = conn.prepareStatement(emp_count);
			ResultSet rs = pst_1.executeQuery();
			
			int a = 0;
			if (rs.next()) {
				a = rs.getInt(1);
			}
			if (a!=0) {
				System.out.println("User already exists");
			} else {
				PreparedStatement pst = conn
						.prepareStatement("insert into user(name,role,telephone,email,username,password) value(?,?,?,?,?,?)");

				pst.setString(1, user.getName());
				pst.setString(2, user.getRole());
				pst.setLong(3 , user.getTelphone());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getUserName());
				pst.setString(6, user.getPwd());


				int count = pst.executeUpdate();
				if (count == 1) {
					response = "User added";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;

	}
}
