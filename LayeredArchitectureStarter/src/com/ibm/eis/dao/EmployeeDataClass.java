package com.ibm.eis.dao;

import java.util.HashMap;
import java.util.Map;

import com.ibm.eis.bean.Employee;

public class EmployeeDataClass implements EmployeeData {

	private Map<Integer,Employee> map = new HashMap<>();
	
	@Override
	public void storeEmployeeData(int id, Employee employee) {
			
		map.put(id, employee);
	}

	@Override
	public Employee displayEmployeeDetails(String name, String designation) {
		
		for(Employee temp : map.values()) {
			if(temp.getName().equalsIgnoreCase(name) && temp.getDesignation().equalsIgnoreCase(designation)) {
				return temp;
			}
		}
		return null;
	}

	
}
