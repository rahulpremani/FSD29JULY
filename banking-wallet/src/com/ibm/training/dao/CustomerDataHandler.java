package com.ibm.training.dao;

import java.util.ArrayList;

import com.ibm.training.beans.Transaction;
import com.ibm.training.beans.Customer;

public interface CustomerDataHandler {

	boolean checkUser(String userName);
	String checkCredentials(String usernName, String password);
	boolean createAccount(Customer customer);
	float showBalance(String mobileNumber);
	boolean depositMoney(String mobileNumber, float amount);
	boolean withdrawMoney(String mobileNumber, float amount);
	boolean transferFund(String sourceAccountNumber, String targetAccountNumber, float amount);
	ArrayList<Transaction> printTransactions(String accountNumber);
}
