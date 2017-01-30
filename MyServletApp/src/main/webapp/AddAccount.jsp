<!DOCTYPE html>
<%@page errorPage="/error.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>View Accoun </h4>

	<form action="/accountOperation.do" >
        <input type="text" name="accountNumber" />
        <input type="submit" />
	</form>

</body>
</html>