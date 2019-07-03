<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- pom.xml에서 jst1을 이미 dependency하고있기때문에 바로 찾을 수 있다. -->

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 날짜나 숫자 도와주는 태그 -->
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script src="http://code.jquery.com/jquery-3.3.1.min.js">

</script>