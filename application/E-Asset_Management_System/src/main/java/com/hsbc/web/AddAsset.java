package com.hsbc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Asset;
import com.hsbc.entity.User;
import com.hsbc.service.AssetDao;
import com.hsbc.service.RegisterDao;
import com.hsbc.util.DBUtil;

@WebServlet("/addAsset")
public class AddAsset  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String category = request.getParameter("category");
		String description =(request.getParameter("description"));

		
		String resp = AssetDao.save(new Asset(uname, category,description));
		response.getWriter().write(resp);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
