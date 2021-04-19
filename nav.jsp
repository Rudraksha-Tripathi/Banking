<!doctype html>
<html lang="en">
    <%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
 <head>
  <title>RT Bank</title>
  
  <link rel="stylesheet" href="css/nav.css" type="text/css"/>   
 </head>
 <body>
    <h1>Welcome to RT Bank</h1>
	<div id="all">
    <button class="btn"><a href="transfer.do?id=${cust.cust_id}&name=${cust.name}">Transfer Money</a></button><br>
    <button class="btn"><a href="transactions.do?id=${cust.cust_id}">My Transactions</a></button>
    </div>
    <div class="cust">
    <table>
        <tr><span>Name:<t:out value="${cust.name}" /></span></tr><br>
        <tr><span>Email:<t:out value="${cust.email}" /></span></tr><br>
        <tr><span>Balance:<t:out value="${cust.balance}" /></span></tr>
    </table>
    </div>
    <a href="cust.do" class="back">BACK</a>
 </body>
</html>
