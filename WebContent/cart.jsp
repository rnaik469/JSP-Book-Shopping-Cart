<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
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

	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">

						<tbody>
							<jstl:if test="${sessionScope.cart.size() > 0 }">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col">Name</th>
										<th scope="col">Author</th>
										<th scope="col">Description</th>
										<th scope="col">Quantity</th>
										<th scope="col" class="text-right">Price</th>
										<th scope="col" class="text-right"></th>
										<th></th>
									</tr>
								</thead>
								<jstl:set var="amount" value="${0}" scope="page" />
								<jstl:forEach var="books" items="${sessionScope.cart}">
									<tr>
										<td><img src="img/${books.bookImg}" width=50px
											height="50px" /></td>

										<td>${books.bookName}</td>
										<td>${books.authorName}</td>
										<td>${books.bookDesc}</td>
										<td>${books.bookcount}</td>
										<td style="display: none;" class="dis"text-right">€</td>
										<td class="text-right">Rs.
											${books.bookPrice*books.bookcount}</td>
										<jstl:set var="amount"
											value="${amount =amount+ books.bookPrice*books.bookcount}"
											scope="page" />
										<td class="text-right"><a
											href="remove.app?bookId=${books.bookId}"
											class="btn btn-sm btn-danger">Remove </a></td>
									</tr>
								</jstl:forEach>

								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><strong>Total</strong></td>
									<td class="text-right"><strong>Rs. ${amount}</strong></td>
									<td></td>
								</tr>
							</jstl:if>
							<jstl:if test="${sessionScope.cart.size() == 0 }">
								<section class="jumbotron text-center">
									<div class="container">
										<h1 class="jumbotron-heading">Your Cart is Empty</h1>
									</div>
								</section>
							</jstl:if>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<a class="btn btn-block btn-light" href="books.app">Continue
							Shopping</a>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>