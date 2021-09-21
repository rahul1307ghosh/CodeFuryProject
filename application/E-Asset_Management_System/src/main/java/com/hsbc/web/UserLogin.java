package com.hsbc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.entity.EmployeeDisplayAsset;
import com.hsbc.entity.User;
import com.hsbc.service.LoginDao;
import com.hsbc.service.UserInfoDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoDao dao;

	@Override
	public void init() throws ServletException {
		dao = new UserInfoDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname_email = request.getParameter("userName");
		String id_choice = request.getParameter("uname-email");
		System.out.println("id choice : " + id_choice);
		String pwd = request.getParameter("pwd");
		
		List<User> userList = UserInfoDao.listAll();
		EmployeeDisplayAsset empUser = new EmployeeDisplayAsset();
		empUser = LoginDao.login(uname_email, id_choice, pwd);
		if (empUser.getRole().equalsIgnoreCase("admin")) {
			

			for(User user:userList) {
				if(empUser.getRole().equalsIgnoreCase("admin")) {
					request.getSession(true).setAttribute("adminData", user);
					System.out.println(user);
					userList.remove(user);
					System.out.println(userList);
					request.getSession(true).setAttribute("users", userList);
					request.getRequestDispatcher("/adminHomePage.jsp").forward(request, response);
					System.out.println("Admin Home Page");
					break;
				}
			}
		} else if(empUser.getRole().equalsIgnoreCase("borrower")){
			System.out.println("User Home Page");
			request.getSession(true).setAttribute("userData", empUser.getUser());
			request.getSession(true).setAttribute("borrowedAssets", empUser.getBorrowedAsset());
			System.out.println(empUser.getUser());
//			for(User user:userList) {
//				if(user.getUserName().equals(uname_email) || user.getEmail().equals(uname_email)) {
//					request.getSession(true).setAttribute("userData", user);
//					System.out.println(user);
//					break;
//				}
//			}
			request.getRequestDispatcher("/userHomePage.jsp").forward(request, response);
			
		}else {
			response.getWriter().write("Invalid Credentials");
		}

	}

}
