<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books On Kart</title>

<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<link href="css/product.css" rel="stylesheet" id="bootstrap-css">

<link href="css/cart.css" rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

<link href="css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">Books On Kart</h1>
		</div>
	</section>

<div class="container">

<div class="row">
<jstl:forEach var="books" items="${sessionScope.books}">
<div class="col-md-3">
	<figure class="card card-product">
		<div class="img-wrap">
							<img src="img/${books.bookImg}">
						</div>
		<figcaption class="info-wrap">
			<h6 class="title text-dots">${books.bookName}</h6>
			<h6 style="font-size:13px; " class="title text-dots">By ${books.authorName}</h6>
			<div class="action-wrap">
				<a href="add.app?bookId=${books.bookId}" class="btn btn-primary btn-sm float-right"> Buy </a>
				<div class="price-wrap h5">
					<span style="color:#28a745;" class="price-new">Rs.${books.bookPrice}</span>
				</div> <!-- price-wrap.// -->
			</div> <!-- action-wrap -->
		</figcaption>
	</figure> <!-- card // -->
</div> <!-- col // -->
</jstl:forEach>
</div> <!-- row.// -->


</div> 
<!--container end-->

<br><br><br>
<article class="bg-secondary mb-3">  
<jsp:include page="footer.jsp"></jsp:include>
</article>
</body>
</html>