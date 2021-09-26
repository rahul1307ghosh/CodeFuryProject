package com.hsbc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.AssetCategory;
import com.hsbc.exception.AssetCategoryAlreadyExistException;
import com.hsbc.service.AssetCategoryDao;
import com.hsbc.util.DBUtil;

@WebServlet("/addAssetCategory")
public class AddAssetCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		int lendingPeriod = Integer.parseInt(request.getParameter("lendingPeriod"));
		int lateReturnFee = Integer.parseInt(request.getParameter("lateReturnFee"));
		String daysBanned = (request.getParameter("daysBanned"));

		try {
			String resp = AssetCategoryDao.save(new AssetCategory(category, lendingPeriod, lateReturnFee, daysBanned));
			System.out.println("resp = " + resp);
		} catch (AssetCategoryAlreadyExistException e1) {
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
			e1.printStackTrace();
		}
		request.getRequestDispatcher("/OperationSuccess.jsp").forward(request, response);

		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
