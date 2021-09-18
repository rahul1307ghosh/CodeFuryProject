package com.hsbc.web.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.util.DBUtil;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String role = request.getParameter("role");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String pass1 = request.getParameter("pwd1");
		System.out.println(uname);
		System.out.println(role);
		System.out.println(telephone);
		System.out.println(email);
		System.out.println(userName);
		System.out.println(pass1);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
