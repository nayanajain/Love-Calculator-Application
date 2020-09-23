<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div
{
font-size: 30px;
color: brown;
}
h1
{
color: purple;
font-family: Verdana;
} 
h3
{
color: violet;
font-family: Verdana;
}
</style>
<title>Result page</title>
</head>
<body>
<h1 style="text-align: center">Love Calculator</h1>
<hr/>
<!--<p>UserName is ${uName}</p>
<p>CrushName is ${crushName}</p>  -->
<div align="center">
<h2>The Love Calculator Predicts:-</h2><br/>
<p>${userInfo.uName} and ${userInfo.crushName} are  </p><br/>
    ${appresult }
<br/>

<!--  <a href="/lovecalc/sendEmail/${userInfo.uName}">Send result to email</a>   -->
<a href="/lovecalc/sendEmail">Send result to email</a>

</div>
</body>
</html>