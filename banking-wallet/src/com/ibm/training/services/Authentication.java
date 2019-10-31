package com.ibm.training.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.training.dao.CustomerDataHandlerClass;


@WebServlet("/authentication")
public class Authentication extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String password = request.getParameter("password");
		String userName = "";
		for(Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("userName")) {
				userName = cookie.getValue();
			}
		}
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		String name = null;
		if((name = dataHandler.checkCredentials(userName, password)) != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("mobileNumber", userName);
			response.sendRedirect("dashboard.jsp");
		} else {
			response.getWriter().print("Invalid Password");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
