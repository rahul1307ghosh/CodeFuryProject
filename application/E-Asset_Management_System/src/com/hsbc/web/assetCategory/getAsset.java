package com.hsbc.web.assetCategory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Asset;
import com.hsbc.entity.AssetCategory;
import com.hsbc.entity.User;
import com.hsbc.service.AssetCategoryDao;
import com.hsbc.service.AssetDao;
import com.hsbc.service.RegisterDao;
import com.hsbc.util.DBUtil;

@WebServlet("/getAssetCategory")
public class getAsset  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<AssetCategory> assetList = AssetCategoryDao.listAll();
		request.getSession(true).setAttribute("list", assetList);
		request.getRequestDispatcher("/addAsset.jsp").forward(request, response);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
