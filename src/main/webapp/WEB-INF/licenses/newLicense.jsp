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

<h1>New License</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
	    <p>
	        <form:label path="person">Person</form:label>
	        <form:errors path="person"/>
	         <form:select path="person">
		        <c:forEach items="${persons}" var="person">
		        	<form:option value="${person.id}"><c:out value="${person.firstName}"/></form:option>
		        </c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="state">State</form:label>
	        <form:errors path="state"/>
	        <form:textarea path="state"/>
	    </p>
	    <p>
	        <form:label path="expirationDate">Expiration Date</form:label>
	        <form:errors path="expirationDate"/>
	        <form:input path="expirationDate" type="date"/>
	    </p>   

	    <input type="submit" value="Submit"/>
	</form:form>   

	
</body>
</html>