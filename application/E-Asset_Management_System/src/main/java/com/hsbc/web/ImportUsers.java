package com.hsbc.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hsbc.entity.User;
import com.hsbc.service.RegisterDao;
import com.hsbc.service.UserInfoDao;

@WebServlet("/importUsers")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ImportUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : request.getParts()) {
			part.write("D:\\" + fileName);
			System.out.println("fileName = " + fileName);
		}

		JSONParser parser = new JSONParser();
		JSONArray a = null;
		List<User> failedImportList = new ArrayList<>();

		try {

			a = (JSONArray) parser.parse(new FileReader("D:\\" + fileName));
//			File f = new File("D:\\" + fileName);
			//f.deleteOnExit();//wip

			for (Object o : a) {
				JSONObject empJsonFileModel = (JSONObject) o;

				String uname = (String) empJsonFileModel.get("Name");
				System.out.println("Name = " + uname);

				String role = (String) empJsonFileModel.get("Role");

				long telephone = (long) empJsonFileModel.get("Telephone");

				String email = (String) empJsonFileModel.get("Email");

				String userName = (String) empJsonFileModel.get("UserName");

				String pass = (String) empJsonFileModel.get("Password");

				String resp = RegisterDao.save(new User(uname, role, telephone, email, userName, pass, ""));

				if (resp.equalsIgnoreCase("User already exists")) {
					failedImportList.add(new User(uname, "", telephone, email, userName, "", ""));
				}
					

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("failedImportList = "+ failedImportList);
		request.getSession(true).setAttribute("list", failedImportList);
		request.getRequestDispatcher("/postUserImport.jsp").forward(request, response);

	}

}
