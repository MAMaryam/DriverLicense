<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver License</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container"> <!-- Beginning of Container -->

        <h1>All Licenses</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Person</th>
		            <th>State</th>
		            <th>Expiration Date</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${licenses}" var="license">
		        <tr>
		            <td><a href="/licenses/${license.id }/show"><c:out value="${license.person.firstName} ${license.person.lastName}"/></a></td>
		            <td><c:out value="${license.state}"/></td>
		            <td><c:out value="${license.expirationDate}"/></td>

		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
	</div>
</body>
</html>