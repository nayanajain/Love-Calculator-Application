<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send email page</title>
</head>
<body>
<h4 style="color: blue"> Hi ${userInfo.uName} <br> send result to email</h4>
<form:form action="process-email" method="GET" modelAttribute="emailDTO"> 
<label>Enter email address</label><br/>
<form:input type="text" path="userEmail" />
<input type= "submit" value="send"/>
<!--  <a href="/lovecalc/sendEmail/${userInfo.uName}">Send Result to another email Address</a>   -->

<a href="/lovecalc/sendEmail">Send Result to another email Address</a>
</form:form>

</body>
</html>