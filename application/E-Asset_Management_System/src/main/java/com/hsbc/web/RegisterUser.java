package com.hsbc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.User;
import com.hsbc.service.RegisterDao;
import com.hsbc.util.DBUtil;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String role = "Borrower";
		long telephone = Long.parseLong(request.getParameter("telephone"));
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pwd1");

		String resp = RegisterDao.save(new User(uname, role, telephone, email, userName, pass, ""));

		if (resp.equalsIgnoreCase("User added"))
			request.getRequestDispatcher("/login1.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/register1.jsp").forward(request, response);

		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register1.jsp").forward(request, response);
	}
}
