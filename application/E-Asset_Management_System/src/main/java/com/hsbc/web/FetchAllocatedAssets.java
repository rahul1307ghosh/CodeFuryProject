package com.hsbc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Overdue;
import com.hsbc.service.AssetOverdueMangDao;

@WebServlet("/fetchAllocatedAssets")
public class FetchAllocatedAssets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Overdue> list = AssetOverdueMangDao.listAllAllocatedAssets();
		request.getSession(true).setAttribute("assetList", list);
		request.getRequestDispatcher("/allocatedAssets.jsp").forward(request, response);

	}

}
