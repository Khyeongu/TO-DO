<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<form action="LoginAction" method="post">
		<div>
			<input id="id" name="id" type="text" placeholder="ID를 입력해주세요" />
		</div>
		<div>
			<input id="pw" name="pw" type="password" placeholder="비밀번호를 입력해주세요" />
		</div>
		<div>
			<button>로그인</button>
		</div>
		<div>
			<a href="${context}/member/register"><button type="button">회원가입</button></a>
		</div>
	</form>
</body>
</html>