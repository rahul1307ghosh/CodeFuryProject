package com.hsbc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.AssetManagement;
import com.hsbc.service.AssetOverdueMangDao;
import com.hsbc.util.DBUtil;

@WebServlet("/AssetoverdueMangg")
public class AssetoverdueMangg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text.html");

		int userId = Integer.parseInt(request.getParameter("userId"));
		int assetId = Integer.parseInt(request.getParameter("assetId"));

		String message = "OverDue";
		try {

			String resp = AssetOverdueMangDao.save(new AssetManagement(userId, assetId, message));

			response.getWriter().write(resp);

			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
