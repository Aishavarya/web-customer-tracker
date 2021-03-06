<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css "/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>


<div id="container">
	<div id="content">
	
		<!-- Adding a button -->
		<input type="button" value="Add Customer" 
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"/>
		
		<!-- Adding the search box and button -->
		
		<form:form action="search" method="GET">
			
			Search Customer: <input type="text" name="theSearchName"/>
			
			<input type="submit" name="Search" class="add-button"/>
			
		
		</form:form>
		
		
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Name</th>
				<th>Action</th> 
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
			<!-- Create update link -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
			<!-- Create a delete Url -->
			<c:url var="deleteLink" value="/customer/deleteCustomer">
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
				<tr>
					<td> ${tempCustomer.firstName} </td>
					<td> ${tempCustomer.lastName }</td>
					<td> ${tempCustomer.email} </td>
					
					<!-- display update link -->
					<td><a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete the customer?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table> 
	</div>
</div>
</body>

</html>