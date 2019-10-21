package com.ibm.banking.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.banking.bean.Customer;
import com.ibm.banking.bean.Transaction;
import com.ibm.banking.service.CustomerServiceHandlerClass;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		CustomerServiceHandlerClass serviceHandler = new CustomerServiceHandlerClass();

		boolean outerFlag = true;
		
		float amount = 0.0f;

		do {
			System.out.println("Enter the option :");
			System.out.println("1. Login to an existing account");
			System.out.println("2. Create a new Account");

			int outerOption = scan.nextInt();
			scan.nextLine();

			switch (outerOption) {
			case 1:
				String username = null;
				do {
					System.out.println("Enter your username (Mobile Number):");
					username = scan.nextLine();	
					if(username.length()==10)
						break;
				}while(username.length()<10);
				System.out.println("Enter your password : ");
				String password = scan.nextLine();
				if (serviceHandler.login(username,password)) {

					boolean innerFlag = true;
					do {
						System.out.println("Enter the option :");
						System.out.println("1. Show Balance");
						System.out.println("2. Deposit Money");
						System.out.println("3. Withdraw Money");
						System.out.println("4. Transfer Fund");
						System.out.println("5. Print Transactions");
						System.out.println("6. Logout");

						int innerOption = scan.nextInt();
						scan.nextLine();

						switch (innerOption) {
						case 1:
							System.out.println(serviceHandler.showBalance());
							break;
						case 2:
							System.out.println("Enter the amount you wanna deposit in your account :");
							amount = scan.nextFloat();
							scan.nextLine();
							if(serviceHandler.depositMoney(amount)) {
								System.out.println("Amount deposited Successfully");
							} else {
								System.out.println("There is some issue while depositing the amount");
							}
							break;
						case 3:
							System.out.println("Enter the amount you wanna withdraw from your account :");
							amount = scan.nextFloat();
							scan.nextLine();
							if(serviceHandler.withdrawMoney(amount)) {
								System.out.println("Amount withdrew successfully");
							} else {
								System.out.println("There is some issue while withdrawing the amount");
							}
							break;
						case 4:
							System.out.println("Enter the target account number in which you wanna transfer the fund :");
							String targetAccountNumber = scan.nextLine();
							System.out.println("Enter the amount you wanna transfer :");
							amount = scan.nextFloat();
							scan.nextLine();
							if(serviceHandler.transferFund(targetAccountNumber,amount)) {
								System.out.println("Amount transferred successfully");
							} else {
								System.out.println("You don't have enough balance to transfer the amount");
							}
							break;
						case 5:
							ArrayList<Transaction> al = serviceHandler.printTransactions();
							if (al != null) {
								System.out.println("Date    Transaction Id  Beneficiary  Operation  Amount");
								for(Transaction ts : al) {
									System.out.println(ts);
								}
							} else {
								System.out.println("No transactions available");
							}
							break;
						case 6:
							innerFlag = false;
							break;
						default:
							System.out.println("You have entered wrong option");
							break;
						}
					} while (innerFlag);
				} else {
					System.out.println("Invalid username or password....Please try again");
				}
				break;
			case 2:
				String mobileNumber = "", tempPassword = "", repeatPassword = "";
				float balance = 0.0f;

				do {
					System.out.println("Enter your mobile number(length should be 10):");
					mobileNumber = scan.nextLine();	
					if(mobileNumber.length()==10)
						break;
				}while(mobileNumber.length()<10);

				if (serviceHandler.checkAccount(mobileNumber) == false) {

					Customer customer = new Customer();
					String tempAccountNumber = "10"+ mobileNumber;
					customer.setAccountNumber(tempAccountNumber);
					System.out.println("Enter your name : ");
					customer.setName(scan.nextLine());
					System.out.println("Enter your age : ");
					customer.setAge(scan.nextInt());
					scan.nextLine();
					System.out.println("Enter your gender : ");
					customer.setGender(scan.nextLine());
					customer.setMobileNumber(mobileNumber);
					System.out.println("How much would you like to deposit as your first transaction?");
					balance = scan.nextFloat();
					scan.nextLine();
					customer.setBalance(balance);
					boolean flag = true;
					while (flag) {
						System.out.println("Enter the password(length should be 6-10) :");
						tempPassword = scan.nextLine();
						System.out.println("Repeat the password :");
						repeatPassword = scan.nextLine();
						if (tempPassword.length() >= 6 && tempPassword.length() <= 10 && tempPassword.equals(repeatPassword)) {
							flag = false;
						}
					}
					customer.setPassword(tempPassword);
					serviceHandler.createAccount(customer);
					System.out.println("Account Created Successfully");
				} else {
					System.out.println("This user already exists");
				}
				break;
			default:
				System.out.println("You have entered wrong option");
				break;
			}

			System.out.println("Do you wanna continue.....Yes/No");
			String consent = scan.nextLine();

			if (consent.equalsIgnoreCase("N") || consent.equalsIgnoreCase("No")) {
				outerFlag = false;
			}
		} while (outerFlag);

		scan.close();
	}

}
