<!DOCTYPE html>

<%@page import="trng.pojo.Account" %>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h4>View Account </h4>

<form action="<%= request.getContextPath() %>/accountOperations.do">
    <div>
        <input type="text" name="accountNumber"/>
        <input type="hidden" name="action" value="VIEW_ACCOUNT"/>
        <input type="submit"/>
    </div>
</form>

<%
    if (request.getAttribute("account") != null) {
        Account account = (Account) request.getAttribute("account");
%>
<table>
    <tr>
        <td> Account Id</td>
        <td><%= account.getAccountId() %>
        </td>
    </tr>

    <tr>
        <td> Account Id</td>
        <td><%= account.getName() %>
        </td>
    </tr>

    <tr>
        <td> Account Id</td>
        <td><%= account.getBalance() %>
        </td>
    </tr>
</table>

<%
    }
%>
</body>
</html>