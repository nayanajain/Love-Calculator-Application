<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register result</title>
</head>
<body>
<p> UserName is ${userdetail.uName}</p>
<p> User is ${userdetail.user}</p>
<p>password is ${userdetail.passwd}</p>
<p>Country is ${userdetail.country}</p>
<p>Gender is ${userdetail.gen}</p>
<p>Age is ${userdetail.age}</p>

<p>Hobbies are ${userdetail.hobby}</p>
<p>Email is ${userdetail.communicationDTO.email}</p>
<p> Phone no. is ${userdetail.communicationDTO.phone}</p>
<p>Here i am</p>

</body>
</html>