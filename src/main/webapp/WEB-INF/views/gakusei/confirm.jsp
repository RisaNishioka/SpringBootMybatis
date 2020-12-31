<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- これがわからんかった -->

<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
	<form:form action="/toFinish"  autocomplete="off">

	<h1>confirm</h1>

	<h3>こちらの内容で登録を行います。 (step 3/3)</h3>

	<div class="text">希望日１</div>
	<c:out value="${mendanForm.reqdate1} ${mendanForm.reqtime1}"/>
	<div class="text">希望日２</div>
	<c:out value="${mendanForm.reqdate2} ${mendanForm.reqtime2}"/>
	<div class="text">氏名</div>
	<c:out value="${entryForm.name}"/>
	<div class="text">最終学歴</div>
	<c:out value="${entryForm.finalEducation}"/>
	<div class="text">開発経験有無</div>
	<c:out value="${entryForm.devExp}"/>
	<div class="text">弊社とのマッチングポイント</div>
	<c:out value="${entryForm.matchingPoint}"/>
	<h3></h3>

	<div align="center">
	<input type="submit" value="この内容で登録する">
		</a>
	</div>

	</form:form>
</body>
</html>

