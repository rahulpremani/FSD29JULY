package com.ibm.eis.dao;

import com.ibm.eis.bean.Employee;

public interface EmployeeData {

	void storeEmployeeData(int id, Employee employee);
	Employee displayEmployeeDetails(String name, String designation);
}
