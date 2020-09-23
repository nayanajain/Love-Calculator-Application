<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function validateUserName() {
		var username = document.getElementById("yn").value;
		var crushname = document.getElementById("cn").value;
		if (username.length < 1) {
			alert("please enter at least one letter");
			return false;
		} else {
			return true;
		}

		if (crushname.length < 1) {
			alert("please enter at least one letter");
			return false;
		} else {
			return true;
		}
	}
</script>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>

<style>
div {
	color: blue;
	font-family: Verdana;
	font-size: 25px;
	text-align: center;
}

h1 {
	color: purple;
	font-family: Verdana;
}

.error {
	color: red;
	position: fixed;
	margin: 30px;
	text-align: left
}
</style>
</head>
<body>
	<h1 style="text-align: center">Love Calculator</h1>
	<form:form action="result-page" method="get" modelAttribute="userInfo">

		<div>
			<p>
				<label for="yn">Your Name:</label>
				<form:input id="yn" path="uName" />
				<form:errors path="uName" cssClass="error"></form:errors>
			</p>


			<p>
				<label for="cn">Crush Name:</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="error"></form:errors>
			</p>

			<p>
				<form:checkbox path="termcondition" id="check" />
				It is for fun purpose only

				<form:errors path="termcondition" cssClass="error"></form:errors>
			</p>
			<input type="submit" value="calculate">

		</div>
	</form:form>
</body>
</html>