package com.hsbc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Asset;
import com.hsbc.service.PopularItemsDao;
import com.hsbc.util.DBUtil;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Asset> popularAssetList = PopularItemsDao.getPopularAssets();

		for (Asset a : popularAssetList)
			System.out.println(a.getDateAdded() + " " + a.isAvailable() + " " + a.getAssetName() + " " + a.getType());

		request.getSession(true).setAttribute("popularAssetList", popularAssetList);
		request.getRequestDispatcher("/home.jsp").forward(request, response);

		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
