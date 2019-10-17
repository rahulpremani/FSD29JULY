package com.ibm.eis.service;

import com.ibm.eis.bean.Employee;

public interface EmployeeServices {

	void storeEmployeeData(int id, Employee employee);
	Employee displayEmployeeDetails(String name, String designation);
	String employeeInsuranceScheme(String name, String designation);
}
