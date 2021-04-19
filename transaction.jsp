<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Document</title>
	<link href="css/customer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>Welcome to RT Bank</h1>
	<table border="1" align="center">
		<tr>
			<th>Transaction Id</th>
			<th>Sender</th>
			<th>Reciever</th>
			<th>Amount</th>
		</tr>
	<t:forEach var="i" items="${transactions}">
		<tr>
			<td><span><t:out value="${i.trans_id}" /></span></td>
			<td><span><t:out value="${i.sender}" /></span></td>
			<td><span><t:out value="${i.reciever}" /></span></td>
			<td><span><t:out value="${i.amount}" /></span></td>
		</tr>
	</t:forEach>
	</table>
	<a href="index.html">BACK</a>
</body> 

</html>