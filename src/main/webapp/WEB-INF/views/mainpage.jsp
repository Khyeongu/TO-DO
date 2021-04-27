<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<button type="button" >회원가입</button>
		</div>
	</form>
</body>
</html>