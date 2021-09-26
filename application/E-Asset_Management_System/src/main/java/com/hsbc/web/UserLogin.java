package com.hsbc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.AvailableAssetList;
import com.hsbc.entity.EmployeeDisplayAsset;
import com.hsbc.entity.Overdue;
import com.hsbc.entity.User;
import com.hsbc.service.LoginDao;
import com.hsbc.service.UserInfoDao;

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

		System.out.println("request.getParameter(\"userName\") = " + request.getParameter("userName"));

		String uname_email = request.getParameter("userName");
		String id_choice = request.getParameter("uname-email");
		System.out.println("id choice : " + id_choice);
		String pwd = request.getParameter("pwd");

		EmployeeDisplayAsset empUser = new EmployeeDisplayAsset();
		empUser = LoginDao.login(uname_email, id_choice, pwd);
		System.out.println("empUser = " + empUser);

		if (empUser == null) {
			request.getRequestDispatcher("/loginFail.jsp").forward(request, response);

		} else if (empUser.getRole().equalsIgnoreCase("admin")) {

			List<User> userList = UserInfoDao.listAll();

			for (User user : userList) {
				if (empUser.getRole().equalsIgnoreCase("admin")) {
					request.getSession(true).setAttribute("adminData", user);
					System.out.println(user);
					userList.remove(user);
					System.out.println(userList);
					request.getSession(true).setAttribute("users", userList);
					request.getRequestDispatcher("/admin.jsp").forward(request, response);
					System.out.println("Admin Home Page");
					break;
				}
			}
		} else if (empUser.getRole().equalsIgnoreCase("borrower")) {
			System.out.println("User Home Page");

			List<AvailableAssetList> availList = new ArrayList<AvailableAssetList>();
			availList = LoginDao.DisplayAvailableAsset(empUser.getUserID());
			request.getSession(true).setAttribute("availableAssets", availList);

			request.getSession(true).setAttribute("userData", empUser.getUser());
			request.getSession(true).setAttribute("empID", empUser.getUserID());

			System.out.println("empUser.getUserID() = " + empUser.getUserID());

			request.getSession(true).setAttribute("prevLogin", empUser.getPrevLogin().substring(0, 16));
			request.getSession(true).setAttribute("borrowedAssets", empUser.getBorrowedAsset());

			System.out.println("empUser.getBorrowedAsset() = " + empUser.getBorrowedAsset());

			List<Overdue> overdueList = new ArrayList<Overdue>();
			overdueList = LoginDao.showMessage(empUser.getUserID());
			request.getSession(true).setAttribute("overdueList", overdueList);

			request.getRequestDispatcher("/userDashboard.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/loginFail.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login1.jsp").forward(request, response);
	}

}
