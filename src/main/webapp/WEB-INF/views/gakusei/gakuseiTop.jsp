<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>


<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/total.css">
<!-- <style type="text/css">.text{padding-left:200px;}</style> -->
</head>

<body>
	<h1 class="text">学生の皆様ようこそ</h1>

	<h3 class="text">先日は説明会の参加ありがとうございました。</h3>

	<div class="text">早速ですが面接の日程を調整させて頂ければと思います。</div>
	<div class="text">希望する日程を下記より回答頂けますようお願い致します。</div>
	<br>
	<br>

	<div align="center">
		<a href="<%=request.getContextPath()%>/toMenndanInput"><input
			type="button" value=" 面接日程を入力する "> </a>
	</div>


</body>
</html>

