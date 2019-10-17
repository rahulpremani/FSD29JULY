package com.ibm.eis.service;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.dao.EmployeeDataClass;

public class EmployeeServicesClass implements EmployeeServices {

	EmployeeDataClass edc = new EmployeeDataClass();
	
	@Override
	public void storeEmployeeData(int id, Employee employee) {
		edc.storeEmployeeData(id, employee);
	}

	@Override
	public Employee displayEmployeeDetails(String name, String designation) {
		
		return edc.displayEmployeeDetails(name, designation);
	}

	@Override
	public String employeeInsuranceScheme(String name, String designation) {
		
		Employee emp = edc.displayEmployeeDetails(name, designation);
		
		if(emp != null) {
			return emp.getInsuranceScheme();
		} else {
			return "This person doesn't exist";
		}
	}

}
