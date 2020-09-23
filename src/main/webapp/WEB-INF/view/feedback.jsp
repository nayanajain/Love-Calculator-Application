
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>

<style>
h1 {
	color: blue;
} 

button
{
background-color: green;
width: 100px;
height: 50px;
color: red;
}

</style>
<meta charset="ISO-8859-1">
<title>Feedback</title>
</head>
<body>

	<h1>Give us Feedback</h1>
	<form:form action="thanks" method="get" modelAttribute="feedback" >
		<label for="name">Name:</label>
		<form:input id="email" type="text" path="name" />

		<br />
		<label for="email">Email:</label>
		<form:input id="email" path="email" />
		<br />

		<label>Feedback:</label>
		<form:input type="text" path="feedback" />
		<br />

		<form:button value="Submit" />
	</form:form>
</body>
</html>