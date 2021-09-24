package com.hsbc.web.register;

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

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String role = "Borrower";
		long telephone = Long.parseLong(request.getParameter("telephone"));
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pwd1");
		
		String resp = RegisterDao.save(new User(uname, role, telephone, email, userName, pass, ""));
		response.getWriter().write(resp);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}