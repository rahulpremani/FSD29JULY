package com.ibm.training.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.training.beans.Customer;
import com.ibm.training.dao.CustomerDataHandlerClass;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/createaccount")
public class CreateAccount extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAge(Integer.parseInt(request.getParameter("age")));
		customer.setMobileNumber(request.getParameter("mobileNumber"));
		customer.setGender(request.getParameter("gender"));
		customer.setPassword(request.getParameter("password"));
		customer.setBalance(Float.parseFloat(request.getParameter("balance")));
		customer.setAccountNumber();
		
		if(dataHandler.createAccount(customer)) {
			response.getWriter().print("Account Created successfully. Now Login again with your credentials.");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			response.getWriter().print("Some error might have occured");
			request.getRequestDispatcher("register.html").include(request, response);
		}
	}

}
