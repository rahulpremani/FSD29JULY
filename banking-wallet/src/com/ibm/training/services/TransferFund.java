package com.ibm.training.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.training.dao.CustomerDataHandlerClass;

@WebServlet("/transferfund")
public class TransferFund extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		
		Float amount = Float.parseFloat(request.getParameter("amount"));
		String beneficiary = request.getParameter("beneficiary");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		if(dataHandler.transferFund(request.getSession().getAttribute("mobileNumber").toString(), beneficiary ,amount)) {
			float finalAmount = dataHandler.showBalance(request.getSession().getAttribute("mobileNumber").toString());
			response.getWriter().write("<script>alert('Amount transferred successfully. Your current balance is :"+finalAmount+"');</script>");
			request.getRequestDispatcher("dashboard.jsp").include(request, response);
		} else {
			response.getWriter().write("There is some issue while depositing the money in your account");
		}
	}

}
