<%@ taglib uri="coretag" prefix="c"%>

<div style='float: left; height: 500px; width: 900px; border-style: solid; border-color: green'>

<c:forEach items='${requestScope.success_msgs}' var='message'>
	${message} 	
</c:forEach>
<c:if test="${sessionScope.user eq null}">
	<jsp:forward page="login.do"></jsp:forward>
</c:if>
<c:if test="${param.requestAction eq 'ADD_ACCOUNT'}">
		<jsp:include page="AddAccount.jsp" />
</c:if>

</div>



<%--
\<div style='float: left; height: 500px; width: 900px; border-style: solid; border-color: green'>

	<% 
		java.util.List<String> msgs = (java.util.List) request.getAttribute(HttpRequestConstants.SUCESS_MSGS);
	
		if (msgs != null) {
			for (String msg : msgs) {
				out.println(msg);
			}
		}
	
	%>
	
	<% if (request.getParameter("requestAction") != null && request.getParameter("requestAction").equals("DEPT_ADD_DEPT")) { %>	
		<jsp:include page="AddDept.jsp" />
	<% } %>
		
</div>	

--%>