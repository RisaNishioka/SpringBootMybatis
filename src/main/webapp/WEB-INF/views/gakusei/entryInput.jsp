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
	<form:form action="/toConfirm" modelAttribute="entryForm"
		autocomplete="off">

		<h1>entryInput</h1>

		<h3>あなたの事を少し教えて下さい。 (step 2/3)</h3>

		<label for="name">氏名</label>
		<form:input type="text" id='name' path="name" placeholder="SKI太郎" />
		<h3></h3>

		<label for="name">最終学歴</label>
		<form:select type="select" id='finalEducation' path="finalEducation">
			<option value="北海道大学">北海道大学</option>
			<option value="北海学園大学">北海学園大学</option>
			<option value="北星学園大学">北星学園大学</option>
			<option value="弘前大学">弘前大学</option>
			<option value="天使大学">天使大学</option>
			<option value="札幌市立大学">札幌市立大学</option>
		</form:select>
		<h3></h3>

		<p>
			<label for="name">開発経験有無</label>
			<form:radiobutton name="devExp" path="devExp" value="true" />
			<form:radiobutton name="devExp" path="devExp" value="false" />
		</p>
		<h3></h3>

		<label for="name">弊社とのマッチングポイント</label>
		<form:textarea name="matchingPoint" path="matchingPoint" rows="4"
			cols="40"></form:textarea>
		<h3></h3>

		<h3></h3>

		<div align="center">
			<input type="submit" value="次へ">
		</div>

	</form:form>
</body>
</html>

