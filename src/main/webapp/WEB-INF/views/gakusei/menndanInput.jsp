<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>


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

	<div class="text">希望日１</div>
	<form:input id='reqdate1' path="reqdate1" placeholder="日付を選択してください"/>
	<form:input id='reqtime1' path="reqtime1" placeholder="時刻(00:00)"/>
	<input type="date">
	<div>時刻</div>
	<input type="time">

	<h3></h3>

	<div class="text">希望日２</div>
	<input type="date">
	<div>時刻</div>
	<input type="time">

	<h3></h3>

	<div align="center">
		<a href="<%=request.getContextPath()%>/toEntryInput"> <input
			type="button" value=" 次へ進む ">
		</a>
	</div>

</body>
</html>

