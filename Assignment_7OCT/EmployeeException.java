package com.cg.eis.exception;

public class EmployeeException extends Exception {
	
	public String getMessage() {
		return "The salary should be more than 3000";
	}
}