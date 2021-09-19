package com.hsbc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.User;
import com.hsbc.util.UserDao;
import com.hsbc.util.UserInfoImpl;

@WebServlet("/")
public class UserInfoController extends HttpServlet {

	UserDao dao;
	@Override
		public void init(ServletConfig config) throws ServletException {
			dao = new UserInfoImpl();
			
		}

@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String requestURI = req.getRequestURI();
			System.out.println(requestURI);
			switch (requestURI) {
			case "/E-Asset_Management_System/list":
				
				List<User> userList = dao.listAll();
				req.getSession(true).setAttribute("list", userList);
				req.getRequestDispatcher("/userInformation2.jsp").forward(req, resp);
				break;
				
			default:
				resp.sendError(404, requestURI + " Not Found");
				break;
			}
}
}