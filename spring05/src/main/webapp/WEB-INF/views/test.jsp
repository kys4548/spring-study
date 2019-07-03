<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<script>
function doF(){
	$.ajax({ //다른페이지로 넘어가지않고 현재페이지에서 진행(비동기적)
		type: "post",
		url: "${path}/test/doF",
		//post방식으로 doF URL을 불러온다
		success: function(result){ //리턴받은 값이 result에 있다.
			console.log(result);
			$("#result").html("상품명:"+result.name+",가격:"+result.price);
			//#은 아이디 태그
		}
	});
}
</script>

<h2>링크 테스트</h2>
<a href="${path}/test/doA">doA</a><br/>
<a href="${path}/test/doB">doB</a><br/>
<a href="${path}/test/doC">doC</a><br/>
<a href="${path}/test/doD">doD</a><br/>
<a href="javascript:doF()">doF</a><br/> <!--다음 함수를 실행시켜라-->
<div id="result"></div>
</body>
</html>