package com.hsbc.web.asset;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
		Date date = new Date();  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		String resp = AssetDao.save(new Asset(uname, category,description,dtf.format(now),1));
		response.getWriter().write(resp);
		
		try {
			System.out.println(DBUtil.getConnConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
