package com.ibm.eis.ui;

import java.util.Scanner;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.service.EmployeeServicesClass;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int id = 1, salary = 0;
		String name = "", designation = "", insuranceScheme = "";
		boolean flag = true;
		
		EmployeeServicesClass esc = new EmployeeServicesClass();
		do {
			System.out.println("Enter the option you wanna perform :");
			System.out.println("1. Add Employee");
			System.out.println("2. Find Insurance Scheme");
			System.out.println("3. Display Employee Details");
			
			int option = scan.nextInt();
			scan.nextLine();
			
			switch(option) {
				case 1:
					System.out.println("Enter the name of Employee :");
					name = scan.nextLine();
					System.out.println("Enter the designation of Employee :");
					designation = scan.nextLine();
					boolean salaryFlag = true;
					while(salaryFlag) {
						System.out.println("Enter the salary of the Employee");
						salary = scan.nextInt();
						scan.nextLine();
						if(designation.equalsIgnoreCase("Clerk") && salary<5000) {
							salaryFlag = false;
						}
						else if(designation.equalsIgnoreCase("Manager") && salary>=40000) {
							salaryFlag = false;
						}
						else if(designation.equalsIgnoreCase("Programmer") && salary>=20000 && salary<40000) {
							salaryFlag = false;
						}
						else if(designation.equalsIgnoreCase("System Associate") && salary>5000 && salary<20000) {
							salaryFlag = false;
						} else {
							System.out.println("Invalid salary");
						}
						
					}
					if(designation.equalsIgnoreCase("Clerk")) {
						insuranceScheme = "No scheme";
					}
					if(designation.equalsIgnoreCase("Manager")) {
						insuranceScheme = "Scheme A";
					}
					if(designation.equalsIgnoreCase("Programmer")) {
						insuranceScheme = "Scheme B";
					}
					if(designation.equalsIgnoreCase("System Associate")) {
						insuranceScheme = "Scheme C";
					}
					Employee employee = new Employee(id, salary, name, designation, insuranceScheme);
					esc.storeEmployeeData(id, employee);
					System.out.println("Added Successfully");
					break;
				case 2:
					System.out.println("Enter the name of Employee :");
					name = scan.nextLine();
					System.out.println("Enter the designation of Employee :");
					designation = scan.nextLine();
					System.out.println(esc.employeeInsuranceScheme(name, designation));
					break;
				case 3:
					System.out.println("Enter the name of Employee :");
					name = scan.nextLine();
					System.out.println("Enter the designation of Employee :");
					designation = scan.nextLine();
					Employee temp = esc.displayEmployeeDetails(name, designation);
					if(temp != null) {
						System.out.println(temp);
					} else {
						System.out.println("This Person doesn't exist");
					}
					break;
				default:
					System.out.println("Inappropriate option");
					break;
			}
			
			System.out.println("Do you want to continue?");
			String consent = scan.nextLine();
			if(consent.equalsIgnoreCase("N") || consent.equalsIgnoreCase("No"))
				flag = false;
		}while(flag);
		
		scan.close();
	}

}
