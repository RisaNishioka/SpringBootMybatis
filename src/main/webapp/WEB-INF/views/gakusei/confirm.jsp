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
	<h1>confirm</h1>

	<h3>こちらの内容で登録を行います。 (step 3/3)</h3>

	<div class="text">希望日１</div>
	<c:out values="${mendanForm.reqdate1} ${mendanFrom.reqtime1}"/>
	<div class="text">希望日２</div>
	<div class="text">氏名</div>
	<div class="text">最終学歴</div>
	<div class="text">開発経験有無</div>
	<div class="text">弊社とのマッチングポイント</div>
	<h3></h3>

	<div align="center">
		<a href="<%=request.getContextPath()%>/toFinish"> <input
			type="button" value=" この内容で登録する ">
		</a>
	</div>


</body>
</html>

