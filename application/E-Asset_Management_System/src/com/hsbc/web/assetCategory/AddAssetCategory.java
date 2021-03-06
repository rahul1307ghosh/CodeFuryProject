package com.hsbc.web.assetCategory;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Asset;
import com.hsbc.entity.AssetCategory;
import com.hsbc.service.AssetCategoryDao;
import com.hsbc.service.AssetDao;
import com.hsbc.util.DBUtil;
@WebServlet("/addAssetCategory")
public class AddAssetCategory  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		int lendingPeriod =Integer.parseInt(request.getParameter("lendingPeriod"));
		int lateReturnFee =Integer.parseInt(request.getParameter("lateReturnFee"));
		String daysBanned = (request.getParameter("daysBanned"));

		
		String resp = AssetCategoryDao.save(new AssetCategory(category,lendingPeriod,lateReturnFee,daysBanned));
		response.getWriter().write(resp);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

