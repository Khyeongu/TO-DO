<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%
Calendar cal = Calendar.getInstance();
session = request.getSession();
%>
<link rel="stylesheet" href="${context}/resources/css/calendar.css">
<link rel="stylesheet" href="${context}/resources/css/bootstrap.css">
<head>
<meta charset="UTF-8">
<title>캘린더</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">TO-DO</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active" href="#">Calendar
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Alarm</a>
					</li>
					
				</ul>
				<form class="d-flex">
					<input class="form-control me-sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="wrap-calendar">
			<div class="my-calendar clearfix">
				<div class="clicked-date">
					<div class="cal-day"></div>
					<div class="cal-date"></div>
				</div>
				<div class="calendar-box">
					<div class="ctr-box clearfix">
						<button type="button" title="prev" class="btn-cal prev"></button>
						<span class="cal-month"></span> <span class="cal-year"></span>
						<button type="button" title="next" class="btn-cal next"></button>
					</div>
					<table class="cal-table">
						<thead>
							<tr>
								<th>S</th>
								<th>M</th>
								<th>T</th>
								<th>W</th>
								<th>T</th>
								<th>F</th>
								<th>S</th>
							</tr>
						</thead>
						<tbody class="cal-body"></tbody>
					</table>
				</div>
			</div>
			<form action="scheduleInsert" method="post">
				<div id="selectDate"></div>
			</form>
		</div>
		<div class="my-schedule">
			<p>Schedule List</p>
		</div>
		<!-- // .my-calendar -->
		<script type="text/javascript"
			src="${context}/resources/js/buildCalendar.js"></script>
	</div>
</body>
</html>