package com.hsbc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		String role = LoginDao.login(uname_email, id_choice, pwd);
		if (role.equalsIgnoreCase("admin")) {
			

			for(User user:userList) {
				if(user.getRole().equalsIgnoreCase(role)) {
					request.getSession(true).setAttribute("adminData", user);
					System.out.println(user);
					userList.remove(user);
					System.out.println(userList);
					request.getSession(true).setAttribute("list", userList);
					request.getRequestDispatcher("/adminHomePage.jsp").forward(request, response);
					System.out.println("Admin Home Page");
					break;
				}
			}
		} else if(role.equalsIgnoreCase("borrower")){
			System.out.println("User Home Page");

			for(User user:userList) {
				if(user.getUserName().equals(uname_email) || user.getEmail().equals(uname_email)) {
					request.getSession(true).setAttribute("userData", user);
					System.out.println(user);
					break;
				}
			}
			request.getRequestDispatcher("/userHomePage.jsp").forward(request, response);
			
		}else {
			response.getWriter().write(role);
		}

	}

}
