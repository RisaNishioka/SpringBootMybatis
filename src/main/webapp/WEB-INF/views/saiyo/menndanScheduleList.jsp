<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>現在の面談予約状況</h3>

	<form:form action="/menndanScheduleList
	"
		modelAttribute="inquiryForm" autocomplete="off">

		<form:input type="date" id='startDate' path="startDate"
			placeholder="日付を選択してください" />
		<form:input type="time" id='startTime' path="startTime"
			placeholder="時刻(00:00)" />
		<h3></h3>

		<form:input type="date" id='endDate' path="endDate"
			placeholder="日付を選択してください" />
		<form:input type="time" id='endTime' path="endTime"
			placeholder="時刻(00:00)" />
		<h3></h3>

		<div align="center">
			<input type="submit" value="照会">
		</div>
	</form:form>

		<h3></h3>

	<form:form action="/menndanScheduleListInquiry"
		modelAttribute="inquiryForm" autocomplete="off">

	<table border="1">
		<tr>
			<th>受付番号</th>
			<th>希望1</th>
			<th>希望2</th>
			<th>氏名</th>
			<th>最終学歴</th>
			<th>開発経験有無</th>
			<th>選択</th>
		</tr>
		<c:forEach var="inquiryFromValue" items="${inquiryForm.inquiryList}">
			<tr>
				<td>${inquiryFromValue.get("RECEPTION_NO")}</td>
				<td>${inquiryFromValue.get("REQUEST_DATE1")}</td>
				<td>${inquiryFromValue.get("REQUEST_DATE2")}</td>
				<td>${inquiryFromValue.get("NAME")}</td>
				<td>${inquiryFromValue.get("SCHOOL")}</td>
				<td>${inquiryFromValue.get("DEV")}</td>
				<td><div align="center"><input type="submit" value="選択"></div></td>
			</tr>
		</c:forEach>
	</table>
	</form:form>

</body>
</html>