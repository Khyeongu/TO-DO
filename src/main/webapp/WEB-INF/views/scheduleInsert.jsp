<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	session=request.getSession();
%>
<c:set var="selectedDate" value="${selectedDate}" />
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 $.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년',
	    changeMonth:true,
	    changeYear:true 
	  });
  $( function() {
    $( "#startDate, #endDate" ).datepicker({
        showOn:"button",
        buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
        buttonImageOnly: true
        });
  } );
  </script>
</head>
<body>
	<h2>일정을 등록해주세요</h2>
	<form action="ScheduleInsertAction" method="post">
		<div>
			<input id="startDate" name="startDate" type="text"
				value="${selectedDate}" placeholder="시작일" />
		</div>
		<div>
			<input id="endDate" name="endDate" type="text" placeholder="종료일" />
		</div>
		<div>
			<input id="title" name="title" type="text" placeholder="일정 이름" />
		</div>
		<div>
			<input id="content" name="content" type="text" placeholder="내용" />
		</div>
		<div>
			<input id="memberNo" name="memberNo" type="hidden" value=<%=session.getAttribute("memberNo") %> />
		</div>
		<div>
			<button>일정 등록</button>
		</div>
	</form>
</body>
</html>