package com.ibm.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ibm.banking.bean.Customer;
import com.ibm.banking.bean.Transaction;

public class CustomerDataHandlerClass implements CustomerDataHandler {

	Connection dbCon = null;

	public CustomerDataHandlerClass() {

		this.dbCon = new JDBCConnection().createConnection();
	}

	@Override
	public void createAccount(Customer customer) {

		String insertQry = "insert into customer_details(accountNumber,name,age,mobileNumber,gender,balance,password) values(?,?,?,?,?,?,?)";
		String entryIntoLedger = "insert into transactions(accountNumber,amount,operation,sourceOrTarget) values(?,?,?,?)";

		try {

			PreparedStatement pstmt1 = dbCon.prepareStatement(insertQry);

			pstmt1.setString(1, customer.getAccountNumber());
			pstmt1.setString(2, customer.getName());
			pstmt1.setInt(3, customer.getAge());
			pstmt1.setString(4, customer.getMobileNumber());
			pstmt1.setString(5, customer.getGender());
			pstmt1.setFloat(6, customer.getBalance());
			pstmt1.setString(7, customer.getPassword());

			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = dbCon.prepareStatement(entryIntoLedger);

			pstmt2.setString(1, customer.getAccountNumber());
			pstmt2.setFloat(2, customer.getBalance());
			pstmt2.setString(3, "Credit");
			pstmt2.setString(4, "Self");
			pstmt2.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public float showBalance(String accountNumber) {

		String showBalanceQry = "select balance from customer_details where accountNumber = ?";
		float balance = 0.0f;

		try {
			PreparedStatement pstmt = dbCon.prepareStatement(showBalanceQry);

			pstmt.setString(1, accountNumber);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				balance = rs.getFloat("balance");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public boolean depositMoney(String accountNumber, float amount) {

		String depositMoneyQry = "update customer_details set balance = ? where accountNumber = ?";
		String entryIntoLedger = "insert into transactions(accountNumber,amount,operation,sourceOrTarget) values(?,?,?,?)";

		try {
			PreparedStatement pstmt = dbCon.prepareStatement(depositMoneyQry);

			pstmt.setFloat(1, this.showBalance(accountNumber) + amount);
			pstmt.setString(2, accountNumber);

			PreparedStatement pstmt1 = dbCon.prepareStatement(entryIntoLedger);

			pstmt1.setString(1, accountNumber);
			pstmt1.setFloat(2, amount);
			pstmt1.setString(3, "Credit");
			pstmt1.setString(4, "Self");

			if (pstmt.executeUpdate() > 0) {
				pstmt1.executeUpdate();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdrawMoney(String accountNumber, float amount) {

		if (this.showBalance(accountNumber) > amount) {

			String withdrawMoneyQry = "update customer_details set balance = ? where accountNumber = ?";
			String entryIntoLedger = "insert into transactions(accountNumber,amount,operation,sourceOrTarget) values(?,?,?,?)";

			try {
				PreparedStatement pstmt = dbCon.prepareStatement(withdrawMoneyQry);

				pstmt.setFloat(1, this.showBalance(accountNumber) - amount);
				pstmt.setString(2, accountNumber);

				PreparedStatement pstmt1 = dbCon.prepareStatement(entryIntoLedger);

				pstmt1.setString(1, accountNumber);
				pstmt1.setFloat(2, amount);
				pstmt1.setString(3, "Debit");
				pstmt1.setString(4, "Self");

				if (pstmt.executeUpdate() > 0) {
					pstmt1.executeUpdate();
					return true;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean transferFund(String sourceAccountNumber, String targetAccountNumber, float amount) {

		if (this.showBalance(sourceAccountNumber) > amount) {

			String transferFundSenderQry = "update customer_details set balance = ? where accountNumber = ?";
			String transferFundReceiverQry = "update customer_details set balance = ? where accountNumber = ?";
			String entryIntoLedgerSender = "insert into transactions(accountNumber,amount,operation,sourceOrTarget) values(?,?,?,?)";
			String entryIntoLedgerReceiver = "insert into transactions(accountNumber,amount,operation,sourceOrTarget) values(?,?,?,?)";

			try {
				PreparedStatement pstmt = dbCon.prepareStatement(transferFundSenderQry);

				pstmt.setFloat(1, this.showBalance(sourceAccountNumber) - amount);
				pstmt.setString(2, sourceAccountNumber);

				PreparedStatement pstmt1 = dbCon.prepareStatement(transferFundReceiverQry);

				pstmt1.setFloat(1, this.showBalance(targetAccountNumber) + amount);
				pstmt1.setString(2, targetAccountNumber);

				PreparedStatement pstmt2 = dbCon.prepareStatement(entryIntoLedgerSender);

				pstmt2.setString(1, sourceAccountNumber);
				pstmt2.setFloat(2, amount);
				pstmt2.setString(3, "Debit");
				pstmt2.setString(4, targetAccountNumber);

				PreparedStatement pstmt3 = dbCon.prepareStatement(entryIntoLedgerReceiver);

				pstmt3.setString(1, targetAccountNumber);
				pstmt3.setFloat(2, amount);
				pstmt3.setString(3, "Credit");
				pstmt3.setString(4, sourceAccountNumber);

				if (pstmt.executeUpdate() > 0 && pstmt1.executeUpdate() > 0) {
					pstmt2.executeUpdate();
					pstmt3.executeUpdate();
					return true;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		} 
		return false;
	}

	@Override
	public ArrayList<Transaction> printTransactions(String accountNumber) {

		String getTransactionsListQry = "Select * from transactions where accountNumber = ?";
		ArrayList<Transaction> al = null;

		try {
			PreparedStatement pstmt = dbCon.prepareStatement(getTransactionsListQry);

			pstmt.setString(1, accountNumber);

			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				al = new ArrayList<>();
				while (rs.next()) {
					Transaction ts = new Transaction();
					ts.setSourceAccountNumber(accountNumber);
					ts.setAmount(rs.getInt("amount"));
					ts.setTransactionId(rs.getInt("transactionId"));
					ts.setOperation(rs.getString("operation"));
					ts.setTargetAccountNumber(rs.getString("sourceOrTarget"));
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					
					String date = simpleDateFormat.format(simpleDateFormat.parse(rs.getString("transactionDate")));
					ts.setTransactionDate(date);
					al.add(ts);
				}
			}

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}

		return al;
	}

	@Override
	public String checkCredentials(String username, String password) {

		String checkCredentialsQry = "Select password, accountNumber from customer_details where mobileNumber = ?";

		try {
			PreparedStatement pstmt = dbCon.prepareStatement(checkCredentialsQry);

			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();
			String tempPassword = "";
			String accountNumber = "";

			if (rs != null) {
				while (rs.next()) {
					tempPassword = rs.getString("password");
					accountNumber = rs.getString("accountNumber");
				}
				if (tempPassword.equals(password)) {
					return accountNumber;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int numberOfAccounts() {
		String getNumberOfAccountsQry = "Select count(*) from customer_details";

		int number = 0;
		try {
			PreparedStatement pstmt = dbCon.prepareStatement(getNumberOfAccountsQry);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				number = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return number;
	}

	@Override
	public boolean checkAccount(String mobileNumber) {

		String checkAccountQry = "Select * from customer_details where mobileNumber = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = dbCon.prepareStatement(checkAccountQry);
			
			pstmt.setString(1, mobileNumber);
			ResultSet rs = pstmt.executeQuery();
			result = rs.next();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

}
