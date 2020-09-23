<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div
{
text-align: center;
font-size: 30px;
color: darkgreen;
}
h1
{
text-align: center;
color: Violet;
font-size: 40px;
}

.error
{
color: red;
position: fixed;
margin: 30px;
text-align: left
}


</style>
<title>Registration Page</title>
</head>
<body>

<h1>Love Calculator Registration Page</h1>
<hr/>  
<form:form action="showregister" method="post" modelAttribute="userdetail" >
<div>
<table style="text-align: center;">
<tr>
<td>
<label>User</label>
<form:input path="user"  type="text" />

</td>
</tr>
<tr>
<td>
<label for="yn">User name</label>
<form:input  id="yn"  type="text" path="uName" />
<form:errors path="uName" cssClass="error"></form:errors>


</td>
</tr>
<tr>
<td>
<label for="pass">Password</label>
<form:password id="pass"  path="passwd" />
</td>
</tr>

<tr>
<td>
<label for="country">Country</label>
<form:select id="country"  path="country" >
<form:option path="cou" value="ind">India</form:option>
<form:option path="cou" value="usa">USA</form:option>
<form:option path="cou" value="aus">Australia</form:option>
<form:option path="cou" value="nz">Newzealand</form:option>
</form:select>

</td>
</tr>
<tr><td>
<label>Age</label>
<form:input path="age" /></td>
<form:errors path="age" cssClass="error"/>
</tr>




<tr><td>
<label>Gender</label>
M <form:radiobutton path="gen" value="m"/>
F <form:radiobutton path="gen" value="f"/>
</td>
</tr>

<tr>
<td>
<label>Hobby</label>
Cricket<form:checkbox path="hobby" value="cricket" />
Reading<form:checkbox path="hobby" value="reading" />
Movies<form:checkbox path="hobby" value="movies" />
</td>
</tr>

<tr>
<td>
<h2 style="color: purple;">Communication</h2>
<label>Email</label>
<form:input path="communicationDTO.email"/>
<form:errors path="communicationDTO.email" cssClass="error"/>

</td>
</tr>
<tr><td>
  <label>PhoneNo</label>
<form:input path="communicationDTO.phone"/>
<form:errors path="communicationDTO.phone" cssClass="error" />
</td></tr>

<tr>
<td>
<input type="submit" value="register">


</td>
</tr>

</table>
</div>

</form:form>

</body>
</html>