<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
	<h1>menndanInput</h1>

	<h3 class="text">面談の希望日程をお聞かせ下さい (step 1/3)</h3>

	<form:form action="/toEntryInput" modelAtrribute="mendanForm"
		autocomplete="off">

		<div class="text">希望日１</div>
		<form:input id='reqdate1' path="reqdate1" placeholder="日付を選択してください" />
		<form:input id='reqtime1' path="reqtime1" placeholder="時刻(00:00)" />
		<h3></h3>

		<div class="text">希望日２</div>
		<input type="date">
		<div>時刻</div>
		<input type="time">

		<h3></h3>

		<div align="center">
			<input type="submit" value="次へ">
		</div>

	</form:form>
</body>
</html>

