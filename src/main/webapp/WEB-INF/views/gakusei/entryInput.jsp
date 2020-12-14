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
	<h1>entryInput</h1>

	<h3>あなたの事を少し教えて下さい。 (step 2/3)</h3>

	<label for="name">氏名</label>
	<input type="text">
	<h3></h3>

	<label for="name">最終学歴</label>
	<select name="school">
		<option value="hokkaido">北海道大学</option>
		<option value="hokkaigakuen">北海学園大学</option>
		<option value="hokusei">北星学園大学</option>
		<option value="hirosaki">弘前大学</option>
		<option value="tenshi">天使大学</option>
		<option value="sapporoichiritsu">札幌市立大学</option>
	</select>
	<h3></h3>

	<p>
		<label for="name">開発経験有無</label><input type="radio" name="experience"
			value="有"><input type="radio" name="experience" value="無">
	</p>
	<h3></h3>

	<label for="name">弊社とのマッチングポイント</label>
	<textarea name="matchingpoint" rows="4" cols="40"></textarea>
	<h3></h3>

	<h3></h3>

	<div align="center">
		<a href="<%=request.getContextPath()%>/toConfirm"> <input
			type="button" value=" 次へ進む ">
		</a>
	</div>


</body>
</html>

