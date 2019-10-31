<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, com.ibm.training.beans.Transaction" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
	$(document).on("click", "#v-pills-show-balance-tab", function() {
		$.get("showbalance", function(responseText) {
			var balanceDisplay = "Your account balance is Rs." + responseText;
			$("#v-pills-show-balance").text(balanceDisplay);
		});
	});

	$("#depositMoney").submit(function(e) {

		var form = $(this);
		var url = form.attr('action');

		$.ajax({
			type : form.attr('method'),
			url : form.attr('action'),
			data : form.serialize()
		}).done(function(data) {
			alert(data);
		}).fail(function(data) {
			alert(data);
		});
		e.preventDefault();
	});

	$("#withdrawMoney").submit(function(e) {

		var form = $(this);
		var url = form.attr('action');

		$.ajax({
			type : form.attr('method'),
			url : form.attr('action'),
			data : form.serialize()
		}).done(function(data) {
			alert(data);
		}).fail(function(data) {
			alert(data);
		});
		e.preventDefault();
	});
	
	$("#transferFund").submit(function(e) {

		var form = $(this);
		var url = form.attr('action');

		$.ajax({
			type : form.attr('method'),
			url : form.attr('action'),
			data : form.serialize()
		}).done(function(data) {
			alert(data);
		}).fail(function(data) {
			alert(data);
		});
		e.preventDefault();
	});
	
	$(document).on("click", "#v-pills-print-transactions-tab", function() {
		$.get("printtransactions", function(responseText) {
			alert("Printing....");
		});
	});
</script>
</head>
<body>
	<br>
	<h1 style="font-family: Comic sans script">
		Welcome
		<%=session.getAttribute("name")%>
	</h1>
	<p style="margin-top: -50px; margin-left: 1180px;">
		<a href="logout">Logout</a>
	</p>
	<br>
	<br>
	<div class="row">
		<div class="col-3">
			<div class="nav flex-column nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<a class="nav-link" id="v-pills-show-balance-tab"
					data-toggle="pill" href="#v-pills-show-balance" role="tab"
					aria-controls="v-pills-show-balance" aria-selected="true">Show
					Balance</a> <a class="nav-link" id="v-pills-deposit-money-tab"
					data-toggle="pill" href="#v-pills-deposit-money" role="tab"
					aria-controls="v-pills-deposit-money" aria-selected="false">Deposit
					Money</a> <a class="nav-link" id="v-pills-withdrawal-money-tab"
					data-toggle="pill" href="#v-pills-withdrawal-money" role="tab"
					aria-controls="v-pills-withdrawal-money" aria-selected="false">Withdrawal
					Money</a> <a class="nav-link" id="v-pills-transfer-fund-tab"
					data-toggle="pill" href="#v-pills-transfer-fund" role="tab"
					aria-controls="v-pills-transfer-fund" aria-selected="false">Transfer Fund
					</a> <a class="nav-link" id="v-pills-print-transactions-tab"
					data-toggle="pill" href="#v-pills-print-transactions" role="tab"
					aria-controls="v-pills-print-transactions" aria-selected="false">Transactions</a>
			</div>
		</div>
		<div class="col-9">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-show-balance"
					role="tabpanel" aria-labelledby="v-pills-show-balance-tab">
					
				</div>
				<div class="tab-pane fade" id="v-pills-deposit-money"
					role="tabpanel" aria-labelledby="v-pills-deposit-money-tab">
					<form id="depositMoney" action="depositmoney" method="post">
						<div class="form-group">
							<label for="usr">Amount</label> <input type="text"
								class="form-control" name="amount">
						</div>
						<button class="btn btn-outline-primary">Submit</button>
					</form>
				</div>
				<div class="tab-pane fade" id="v-pills-withdrawal-money"
					role="tabpanel" aria-labelledby="v-pills-withdrawal-money-tab">
					<form id="withdrawalMoney" action="withdrawmoney" method="post">
						<div class="form-group">
							<label for="usr">Amount</label> <input type="text"
								class="form-control" name="amount">
						</div>
						<button class="btn btn-outline-primary">Submit</button>
					</form>
				</div>
				<div class="tab-pane fade" id="v-pills-transfer-fund"
					role="tabpanel" aria-labelledby="v-pills-transfer-fund-tab">
					<form id="transferFund" action="transferfund" method="post">
						<div class="form-group">
							<label for="amount">Amount</label> <input type="text"
								class="form-control" name="amount">
						</div>
						<div class="form-group">
							<label for="beneficiary">Beneficiary's Mobile Number</label> <input type="text"
								class="form-control" name="beneficiary">
						</div>
						<button class="btn btn-outline-primary">Submit</button>
					</form>
				</div>
				<div class="tab-pane fade" id="v-pills-print-transactions"
					role="tabpanel" aria-labelledby="v-pills-print-transactions-tab">
					<%
						List<Transaction> temp = (ArrayList<Transaction>)request.getSession().getAttribute("transactions");
						
							if(temp != null){
								out.print("<table style='height: 100%; width: 100%; text-align: center;'>");
								out.print("<tr>");
								out.print("<th>Date</th><th>Transaction Id</th><th>Source</th><th>Operation</th><th>Amount</th>");
							for(Transaction ts :temp){
								out.print("<tr>");
								out.print("<td>"+ts.getTransactionDate()+"</td>");
								out.print("<td>"+ts.getTransactionId()+"</td>");
								out.print("<td>"+ts.getTargetAccountNumber()+"</td>");
								out.print("<td>"+ts.getOperation()+"</td>");
								out.print("<td>"+ts.getAmount()+"</td>");
								out.print("</tr>");
							}
							out.print("</table>");
						} else {
							out.println("No transactions available");
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>