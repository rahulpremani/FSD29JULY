package com.ibm.banking.dao;

import java.util.ArrayList;

import com.ibm.banking.bean.Customer;
import com.ibm.banking.bean.Transaction;

public interface CustomerDataHandler {

	void createAccount(Customer customer);
	float showBalance(String accountNumber);
	boolean depositMoney(String accountNumber, float amount);
	boolean withdrawMoney(String accountNumber, float amount);
	boolean transferFund(String sourceAccountNumber, String targetAccountNumber, float amount);
	ArrayList<Transaction> printTransactions(String accountNumber);
	String checkCredentials(String username, String password);
	int numberOfAccounts();
	boolean checkAccount(String mobileNumber);
}
