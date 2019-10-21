## Pre-requisites
You should have maven m2e in eclipse. 
Create a database named 'banking_database'.
Create two tables 'customer_details' and 'transactions'.
customer_details (accountNumber varchar(12), name varchar(35), age int(3), gender varchar(20), mobileNumber varchar(10), balance float, password varchar(10))
transactions (accountNumber varchar(12), transactionId int(5), amount float, operation varchar(10), sourceOrTarget varchar(12), transactionDate varchar(300) default CURRENT_TIMESTAMP)
