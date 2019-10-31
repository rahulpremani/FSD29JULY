package com.ibm.training.beans;

public class Transaction {

	private int amount, transactionId;
	private String operation, targetAccountNumber, transactionDate, sourceAccountNumber;
	
	public String getTransactionDate() {
		return this.transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}
	public void setTargetAccountNumber(String targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
			return this.getTransactionDate() + "\t" + this.getTransactionId() + "\t" + this.getTargetAccountNumber() + "\t" + this.getOperation() + "\t" + this.getAmount();
	}
	
}

