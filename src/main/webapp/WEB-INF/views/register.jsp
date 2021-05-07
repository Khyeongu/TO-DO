<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<header>
		<h1>계정을 생성해 주세요</h1>
	</header>
	
	<form action="MemberRegisterAction" method="post">
		<div>
			<!-- <label for="id">ID</label>  -->
			<input id="id" name="id" type="text" placeholder="ID를 입력해주세요"/>
		</div>
		<div>
			<input id="pw" name="pw" type="password" placeholder="비밀번호를 입력해주세요"/>
		</div>	
		<div>
			<input id="name" name="name" type="text" placeholder="이름을 입력해주세요"/>
		</div>
		<div>
			<button>회원 가입</button>
		</div>
	</form>
</body>
</html>