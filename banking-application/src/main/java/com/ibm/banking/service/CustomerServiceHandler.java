package com.ibm.banking.service;

import java.util.ArrayList;

import com.ibm.banking.bean.Customer;
import com.ibm.banking.bean.Transaction;

public interface CustomerServiceHandler {

	void createAccount(Customer customer);
	float showBalance();
	boolean login(String username, String password);
	boolean depositMoney(float amount);
	boolean withdrawMoney(float amount);
	boolean transferFund(String targetAccountNumber,float amount);
	ArrayList<Transaction> printTransactions();
	int numberOfAccounts();
	boolean checkAccount(String mobileNumber);
}
