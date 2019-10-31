package com.ibm.training.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.training.dao.CustomerDataHandlerClass;

@WebServlet("/showbalance")
public class ShowBalance extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(""+ dataHandler.showBalance(request.getSession().getAttribute("mobileNumber").toString()));
	}
}
