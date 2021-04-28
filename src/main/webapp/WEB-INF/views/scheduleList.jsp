<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%
	Calendar cal = Calendar.getInstance();
%>

<script type="text/javascript"
	src="${context}/resources/js/buildCalendar.js">

</script>

<head>
<meta charset="UTF-8">
<title>캘린더</title>
</head>
<body>
	<div id="date">
		<label id="year"><%=cal.get(Calendar.YEAR)%>년</label>
		<button type="button" onClick="last_month_click()">&lt</button>
		<label id="month"><%=cal.get(Calendar.MONTH) + 1%>월</label>
		<button type="button" onCLick="next_month_click()">&gt</button>
	</div>
	<div id="wrap_calendar">
		<table id="calendar" border="3" style="border-color: #FFFFFF">

			<tr>
				<td align="center"><font color="#F79DC2">일</td>
				<td align="center">월</td>
				<td align="center">화</td>
				<td align="center">수</td>
				<td align="center">목</td>
				<td align="center">금</td>
				<td align="center"><font color="skyblue">토</td>
			</tr>
		</table>
	</div>

	<script language="javascript" type="text/javascript">
		buildCalendar();//
	</script>
</body>
</html>