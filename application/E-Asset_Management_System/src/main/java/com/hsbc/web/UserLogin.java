package com.hsbc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.service.LoginDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname_email = request.getParameter("userName");
		String id_choice = request.getParameter("uname-email");
		System.out.println("id choice : "+id_choice);
		String pwd = request.getParameter("pwd");
		
		String role = LoginDao.login(uname_email, id_choice, pwd);
		if(role.equalsIgnoreCase("admin")) {
			
			System.out.println("Admin Home Page");
		}else{
			System.out.println("User Home Page");
		}
		
	}

}
