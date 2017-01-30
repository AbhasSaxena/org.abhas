<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="coretag" prefix="c"%>
<%@ taglib uri="formattag" prefix="fmt"%>

<html>
<c:set var="loc" value="en_US" />
<c:if test="${!(empty param.locale)}">
	<c:set var="loc" value="${param.locale}" />
</c:if>
<fmt:setLocale value="${loc}" />

<fmt:bundle basename="app">
	<head>
		<title><fmt:message key="email" /></title>
	</head>
	<body>

		<c:url value="confirm.jsp" var="formActionURL" />

		<form action="${formActionURL}" method="post">
			<table>
				<tr>
					<td colspan=2 bgcolor="black"><br />
					
						<center>
							<font face="arial" size=+2 color="white"><b><i>internationalization (i18n)</i> &nbsp; Login</b></font>
						</center> <br /></td>
				</tr>
				<tr>
					<td><fmt:message key="userid" /></td>
					<td><input type="hidden" name="locale" value="${loc}" /> 
					<input	type="text" name="userid" size="40" /></td>
				</tr>

				<tr>
					<td><fmt:message key="password" /></td>
					<td><input type="text" name="pass" size="40" /></td>
				</tr>


				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="<fmt:message key='login'/>" /></td>
				</tr>

			</table>

		</form>

	</body>
</fmt:bundle>

</html>