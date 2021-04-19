<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Document</title>
	<link rel="stylesheet" href="css/transfer.css" type="text/css"/>
</head>
<body>
    <% 
    Integer custId = null;
    if(request.getAttribute("custId")!=null){
        custId = (Integer)request.getAttribute("custId"); 
    }
    %>
    <h1>Welcome to RT Bank</h1>
    <form action="transfer_money.do"><!---->
    <span>From:</span>
    <select name="from" class="fld">
        <% if(custId!=null){ %>
            <option value="${custId}_${custName}" selected>${custName}</option>
        <% }else{ %>
        <t:forEach var="customer" items="${customers}">
            <option value="${customer.cust_id}_${customer.name}">${customer.name}</option>    
        </t:forEach>
        <% } %>
    </select>
    <br>
    <span>To:</span>
    <select name="to" class="fld">
        <t:forEach var="customer" items="${customers}">
            <option value="${customer.cust_id}_${customer.name}">${customer.name}</option>
        </t:forEach>
	</select>
    <br>
    <span>Amount:</span><input class="fld" pattern="[0-9]*{}" type="number" name="amount" placeholder="Amount"/>
    <br>
    <input type="submit" value="SEND" id="sub"/>
    </form>
    <% if(custId!=null){ %>
	    <a href="nav.do?id=${custId}">BACK</a>
    <%}else{%>
        <a href="index.html">BACK</a>
    <%}%>
</body> 
<script src="static/transfer.js"></script>
</html>