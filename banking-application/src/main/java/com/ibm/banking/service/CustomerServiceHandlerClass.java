package com.ibm.banking.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.banking.bean.Customer;
import com.ibm.banking.bean.Transaction;
import com.ibm.banking.dao.CustomerDataHandlerClass;

public class CustomerServiceHandlerClass implements CustomerServiceHandler {

	String accountNumber;

	CustomerDataHandlerClass dataHandler = new CustomerDataHandlerClass();
	Scanner scan = new Scanner(System.in);

	@Override
	public void createAccount(Customer customer) {

		dataHandler.createAccount(customer);
	}

	@Override
	public float showBalance() {

		return dataHandler.showBalance(this.accountNumber);
	}

	@Override
	public boolean login(String username, String password) {

		String value = dataHandler.checkCredentials(username, password);

		if (value.equals("") == false) {
			this.accountNumber = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean depositMoney(float amount) {

		return dataHandler.depositMoney(this.accountNumber, amount);
	}

	@Override
	public boolean withdrawMoney(float amount) {

		return dataHandler.withdrawMoney(this.accountNumber, amount);
	}

	@Override
	public boolean transferFund(String targetAccountNumber,float amount) {

		return dataHandler.transferFund(this.accountNumber, targetAccountNumber, amount);
	}

	@Override
	public ArrayList<Transaction> printTransactions() {

		return dataHandler.printTransactions(this.accountNumber);

	}

	@Override
	public boolean checkAccount(String mobileNumber) {

		return dataHandler.checkAccount(mobileNumber);
	}

	@Override
	public int numberOfAccounts() {
		
		return dataHandler.numberOfAccounts();
	}
}
