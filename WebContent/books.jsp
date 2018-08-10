<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BooksOnKart</title>
<style type="text/css">
.book {
	float: left;
	width: 180px;
	height: 220px;
	position: relative;
	display: block;
	border: 2px solid black;
	margin: 10px;
	padding: 10px;
}

.buy {
	margin-left: 40px;
	margin-top: 80px;
	width: 100px;
	height: 60px;
	background-color: black;
	color: white;
	border: 1px solid black;
	padding: 10px;
	text-decoration: none;
}
</style>
</head>

<body>


	${requestScope.books}
	<jsp:include page="header.jsp"></jsp:include>
	<jstl:forEach var="books" items="${sessionScope.books}">

		<div class="book">
			<h3>${books.bookName}</h3>
			<h6>${books.bookDesc}</h6>
			<h4>${books.authorName}</h4>
			<h4 style="color: green">${books.bookPrice}</h4>
			<a class="buy" href="add.app?bookId=${books.bookId}">Buy</a>
		</div>

	</jstl:forEach>

</body>
</html>