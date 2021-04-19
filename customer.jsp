<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="model.Customer"%>

<head>
    <title>Document</title>
	<link href="css/customer.css" rel="stylesheet" type="text/css"/>
</head>
<% ArrayList<Customer> objs = (ArrayList)session.getAttribute("customers");%>
<body>
	<h1>Welcome to RT Bank</h1>
	<table border="1" align="center">
		<tr>
			<th>Customer Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Balance</th>
		</tr>
	<t:forEach var="i" items="${customers}">
		<tr>
			<td><span><t:out value="${i.cust_id}" /></span></td>
			<td><a href="nav.do?id=${i.cust_id}"><t:out value="${i.name}" /></a></td>
			<td><span><t:out value="${i.email}" /></span></td>
			<td><span><t:out value="${i.balance}" /></span></td>
		</tr>
	</t:forEach>
	</table>
	<a href="index.html">BACK</a>
</body> 

</html>