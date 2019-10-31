package com.ibm.training.services;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.training.dao.CustomerDataHandlerClass;

@WebServlet("/checkuser")
public class CheckUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		
		if(dataHandler.checkUser(userName)) {
			Cookie myCookie = new Cookie("userName",userName);
			response.addCookie(myCookie);
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			response.getWriter().print("This user doesn't exist. Please create a new account.");
			request.getRequestDispatcher("register.html").include(request, response);
		}
	}
}
