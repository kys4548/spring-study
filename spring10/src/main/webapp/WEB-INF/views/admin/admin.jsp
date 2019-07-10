<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<c:if test="${message=='success' }">
	<h2>
		${sessionScope.admin_name }
		(${sessionScope.admin_userid })님 환영합니다.
	</h2>
</c:if>
</body>
</html>