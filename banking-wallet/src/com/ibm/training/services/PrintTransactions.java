package com.ibm.training.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.training.dao.CustomerDataHandlerClass;
import com.google.gson.Gson;
import com.ibm.training.beans.Transaction;

@WebServlet("/printtransactions")
public class PrintTransactions extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDataHandlerClass dataHandler = (CustomerDataHandlerClass) request.getServletContext().getAttribute("dao");
		
		request.getSession().setAttribute("transactions", dataHandler.printTransactions(request.getSession().getAttribute("mobileNumber").toString()));
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	
	}
}

