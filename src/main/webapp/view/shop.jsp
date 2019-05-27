<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ro.ugal.si.model.Product"%>
<%@ page import="ro.ugal.si.dao.ProductDaoImpl"%>
<%@ page import="ro.ugal.si.util.SIVars"%>
<%@ page import="java.io.File"%>
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
	<a href="shop.jsp" class="logo">Welcome to the bookstore</a>
	<div class="header-right">
		<a class="active" href="shop.jsp">Home</a> <a href="checkout.jsp">Checkout</a>
		<a href="../index.jsp">Log Out</a>
	</div>
</div>

<div class="container">
	<div class="col-xs-12 col-md-6">

		<%
			ProductDaoImpl dao = new ProductDaoImpl();
			List<Product> productList = dao.getAllProducts();
			String filepath = null;
			for (Product p : productList) {
				if (p != null) {
		%>
		<!-- First product box start here-->
		<div class="prod-info-main prod-wrap clearfix">

			<div class="row">

				<form action="/si/cart" method="post">
					<div class="col-md-5 col-sm-12 col-xs-12">

						<div class="product-image">
							<img src="../images/<%=p.getPath()%>" class="img-responsive" />
						</div>

					</div>

					<div class="col-md-7 col-sm-12 col-xs-12">

						<div class="product-deatil">

							<h5 class="name">

								<a href="#"><%=p.getName()%> </a> <a href="#"> <span>Author</span>
								</a>

							</h5>

							<p class="price-container">

								<span><%=p.getPrice()%> RON</span>

							</p>

							<span class="tag1"></span>

						</div>

						<div class="description">

							<p><%=p.getDescription()%></p>

						</div>

						<div class="product-info smart-form">

							<div class="row">

								<div class="col-md-12">

									<button class="btn btn-danger" name="addCart" type="submit">Add to cart</button> <input
										type="hidden" id="<%=p.getIdProduct()%>"
										name="hidden"
										value="<%=p.getIdProduct()%>">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- end product -->
		<%
			}
			}
		%>
	</div>
</div>


</body>
</html>