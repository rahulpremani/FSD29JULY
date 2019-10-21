package com.ibm.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	Connection createConnection() {

		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/banking_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
