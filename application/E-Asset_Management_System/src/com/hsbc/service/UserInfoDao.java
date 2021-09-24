package com.hsbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.entity.User;
import com.hsbc.util.DBUtil;

public class UserInfoDao {


	public static List<User> listAll() {
		List<User> userList= new ArrayList<User>();
		
		try {
			Connection conn = DBUtil.getConnConnection();
			PreparedStatement pst = conn.prepareStatement("select * from user");
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				userList.add(new User(rs.getString("NAME"), rs.getString(3), rs.getLong("TELEPHONE"),
						rs.getString("EMAIL"), rs.getString(6), "",rs.getString("LASTLOGIN")));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}
}