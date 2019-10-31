package com.ibm.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {


    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	Connection dbCon = (Connection) sce.getServletContext().getAttribute("dbCon");
    	
    	try {
    		
			dbCon.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	Connection dbCon = null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbCon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/banking_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			
			sce.getServletContext().setAttribute("dbCon", dbCon);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	
    	CustomerDataHandlerClass dataHandler= new CustomerDataHandlerClass(dbCon);
    	sce.getServletContext().setAttribute("dao", dataHandler);
    }
	
}
