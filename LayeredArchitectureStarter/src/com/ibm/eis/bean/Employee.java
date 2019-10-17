package com.ibm.eis.bean;

public class Employee {

	private int id, salary;
	private String name, designation, insuranceScheme;
	public int getId() {
		return id;
	}
	public int getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", designation=" + designation
				+ ", insuranceScheme=" + insuranceScheme + "]";
	}
	public Employee(int id, int salary, String name, String designation, String insuranceScheme) {
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
	}
	
	
}
