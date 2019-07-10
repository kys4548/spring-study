<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Home</title>
<%@ include file="include/header.jsp" %>	
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.userid!='admin'}">
		<%@ include file="include/menu.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="include/admin_menu.jsp" %>
	</c:otherwise>
</c:choose>
<c:if test="${sessionScope.userid !=null }">
<h2>${sessionScope.name} (${sessionScope.userid})
님의 방문을 환영합니다.
</h2>
</c:if>
<h1>Hello world! </h1>

<P>  The time on the server is ${serverTime}. </P>
<%=application.getRealPath("/") %>
</body>
</html>
