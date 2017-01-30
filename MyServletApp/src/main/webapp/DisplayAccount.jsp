<!DOCTYPE html>
<%@ taglib prefix="c" uri="coretag" %>

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


<c:if test="${requestScope.accounts != null}">

    <c:forEach items="${requestScope.accouts}" var="account">


    </c:forEach>
</c:if>

<c:if test="${requestScope.account != null}">

<table>
    <tr>
        <td> Account Id</td>
        <td>${requestScope.account.accountId}</td>
    </tr>

    <tr>
        <td> Account Id</td>
        <td>${requestScope.account.name}</td>
    </tr>

    <tr>
        <td> Account Id</td>
        <td>${requestScope.account.balance}</td>
    </tr>
</table>

</c:if>
</body>
</html>