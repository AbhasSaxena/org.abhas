<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Select Language</title>
</head>
<body>
	<table>
		<tr>
			<td colspan=4 bgcolor="black"><br />
				<center>
					<font face="arial" size=+2 color="white"><b><i>internationalization (i18n)</i>Test 
							Application</b></font>
				</center> <br /></td>
		</tr>
		
		<tr>
			<td colspan=4><br />
				<center>
					<font face="arial" size=3 color="blue"><b>Try by selecting the individual Flags </b></font>
				</center> <br /></td>
		</tr>
		
		<tr>
			<td>
			
				<c:url value="/i18n/i18nLogin.jsp" var="englishURL">
					<c:param name="locale" value="en_US" />
				</c:url> 
				
				<a href="${englishURL}"> <img src="english.gif" />
			</a></td>
			<td><c:url value="/i18n/i18nLogin.jsp" var="japaneseURL">
					<c:param name="locale" value="ja_JP" />
				</c:url> <a href="${japaneseURL}"> <img src="japanese.gif" />
			</a></td>
			<td><c:url value="/i18n/i18nLogin.jsp" var="koreanURL">
					<c:param name="locale" value="ko_KR" />
				</c:url> <a href="${koreanURL}"> <img src="korean.gif" />
			</a></td>
			<td><c:url value="/i18n/i18nLogin.jsp" var="chineseURL">
					<c:param name="locale" value="zh_CN" />
				</c:url> <a href="${chineseURL}"> <img src="chinese.gif" />
			</a></td>
		</tr>
	</table>
</body>
</html>
