<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="formattag" prefix="fmt"%>
<fmt:requestEncoding value="UTF-8" />
<html>
<fmt:setLocale value="${param.locale}"  />
<head>
<fmt:bundle basename="app">
<title><fmt:message key="email"/></title>
</head>
<body>

<table border="1">
<tr>
<td colspan=2 bgcolor="black">
<br/>
<center><font face="arial" size=+2 color="white"><b>
       <font face="arial" size=+2 color="white"><b><i>Given </i>Details</b></font></center>
<br/>

</td>
</tr>
<tr>
<td><fmt:message key="userid"/></td>
<td>${param.userid}</td>
</tr>

<tr>
<td><fmt:message key="password"/></td>
<td>${param.pass}</td>
</tr>





</table>


</body>
</fmt:bundle>

</html>











