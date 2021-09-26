package com.hsbc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.entity.Overdue;
import com.hsbc.service.AssetOverdueMangDao;

@WebServlet("/assetoverdueManagment")
public class FetchOverDueAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<Overdue>  list= AssetOverdueMangDao.listAll();
	request.getSession(true).setAttribute("assetAllocatedList", list);
	request.getRequestDispatcher("/OverDueAsset.jsp").forward(request, response);
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String sortBy=request.getParameter("sortBy");
	if(sortBy.equals("name")) {
	List<Overdue>  list= AssetOverdueMangDao.listAllByName();
	request.getSession(true).setAttribute("assetAllocatedList", list);
	request.getRequestDispatcher("/tableData.jsp").forward(request, response);
	}
	else if(sortBy.equals("due_date")) {
		List<Overdue>  list= AssetOverdueMangDao.listAllByDate();
		request.getSession(true).setAttribute("assetAllocatedList", list);
		request.getRequestDispatcher("/tableData.jsp").forward(request, response);
		}
	else  {
		List<Overdue>  list= AssetOverdueMangDao.listAllByCategory();
		request.getSession(true).setAttribute("assetAllocatedList", list);
		request.getRequestDispatcher("/tableData.jsp").forward(request, response);
		}
	}
}
