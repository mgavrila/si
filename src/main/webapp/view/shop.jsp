<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- STYLE CSS -->
<link rel="stylesheet" href="../css/shop.css">
<link rel="stylesheet" href="../css/header.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<div class="header">
	<a href="#default" class="logo">Welcome to the bookstore</a>
	<div class="header-right">
		<a class="active" href="shop.jsp">Home</a> <a href="checkout.jsp">Checkout</a>
	</div>
</div>

<div class="container">
	<div class="col-xs-12 col-md-6">

		<!-- First product box start here-->
		<div class="prod-info-main prod-wrap clearfix">

			<div class="row">

				<div class="col-md-5 col-sm-12 col-xs-12">

					<div class="product-image">

						<img src="../images/image-2.png" class="img-responsive">
					</div>

				</div>

				<div class="col-md-7 col-sm-12 col-xs-12">

					<div class="product-deatil">

						<h5 class="name">

							<a href="#">Name here </a> <a href="#"> <span>Author</span>
							</a>

						</h5>

						<p class="price-container">

							<span>$199</span>

						</p>

						<span class="tag1"></span>

					</div>

					<div class="description">

						<p>A Short product description here</p>

					</div>

					<div class="product-info smart-form">

						<div class="row">

							<div class="col-md-12">

								<a href="#" class="btn btn-danger">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end product -->
	</div>
</div>
</body>
</html>