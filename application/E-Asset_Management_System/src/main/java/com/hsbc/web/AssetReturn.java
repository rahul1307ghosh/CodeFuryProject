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
import com.hsbc.entity.DisplayAssetList;
import com.hsbc.entity.Overdue;
import com.hsbc.service.AssetReturnDao;
import com.hsbc.service.LoginDao;

@WebServlet("/assetReturn")
public class AssetReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AssetReturnDao.saveReturnedAsset(Integer.parseInt(request.getParameter("targetId")),
				Integer.parseInt(request.getParameter("targetUserId")));

		int userId = (int) request.getSession(true).getAttribute("empID");

		List<AvailableAssetList> availList = new ArrayList<AvailableAssetList>();
		availList = LoginDao.DisplayAvailableAsset(userId);
		request.getSession(true).setAttribute("availableAssets", availList);

		List<DisplayAssetList> borrowedAssets = new ArrayList<DisplayAssetList>();
		borrowedAssets = LoginDao.displayEmployeeAssets(userId);
		request.getSession(true).setAttribute("borrowedAssets", borrowedAssets);

		List<Overdue> overdueList = new ArrayList<Overdue>();
		overdueList = LoginDao.showMessage(userId);
		request.getSession(true).setAttribute("overdueList", overdueList);

		request.getRequestDispatcher("userOpSuccess.jsp").forward(request, response);
	}

}
