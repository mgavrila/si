<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ro.ugal.si.model.Product"%>
<%@ page import="ro.ugal.si.model.User"%>
<%@ page import="ro.ugal.si.dao.ProductDaoImpl"%>
<%@ page import="ro.ugal.si.dao.UserDaoImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" href="../../css/admin/admin.css">
<link rel="stylesheet" href="../../css/header.css">

</head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="header">
	<div class="header-right">
		<a class="active" href="../../index.jsp">Logout</a>
	</div>
</div>

<div class="container">
	<div class="row">
		<h1>Management</h1>
		<div role="tabpanel">
			<div class="col-sm-3">
				<ul class="nav nav-pills brand-pills nav-stacked" role="tablist">
					<li role="presentation" class="brand-nav active"><a
						href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">Add</a></li>
					<li role="presentation" class="brand-nav"><a href="#tab2"
						aria-controls="tab2" role="tab" data-toggle="tab">Update</a></li>
					<li role="presentation" class="brand-nav"><a href="#tab3"
						aria-controls="tab3" role="tab" data-toggle="tab">Delete
							product</a><hr></li>					
					<li role="presentation" class="brand-nav"><a href="#tab4"
						aria-controls="tab4" role="tab" data-toggle="tab">Delete user</a></li>
				</ul>
			</div>
			<div class="col-sm-9">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="tab1">
						<form action="/si/addProduct" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<!-- Name field -->
								<label class="control-label " for="addName">Name</label> <input
									class="form-control" id="addName" name="addName" type="text" />
							</div>

							<div class="form-group">
								<!-- Price field -->
								<label class="control-label requiredField" for="addPrice">Price</label>
								<input class="form-control" id="addPrice" name="addPrice"
									type="text" />
							</div>

							<div class="form-group">
								<!-- Author field -->
								<label class="control-label " for="addAuthor">Author</label> <input
									class="form-control" id="addAuthor" name="addAuthor"
									type="text" />
							</div>

							<!-- Product image field -->
							<div class="form-group">
								<label for="addProductImage">Product image</label> <input
									type="file" class="form-control-file" id="file" name="file">
							</div>


							<div class="form-group">
								<!-- Description field -->
								<label class="control-label " for="addDescription">Description</label>
								<textarea class="form-control" cols="40" id="addDescription"
									name="addDescription" rows="10"></textarea>
							</div>

							<div class="form-group">
								<button class="btn btn-primary " name="addProduct" type="submit">Submit</button>
							</div>

						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="tab2">
						<form action="/si/updateProduct" method="post">
							<%
								ProductDaoImpl updateDao = new ProductDaoImpl();
								List<Product> updateProductList = updateDao.getAllProducts();
								for (Product product : updateProductList) {
									if (product != null) {
							%>

							<div class="container">
								<div class="col-xs-12 col-md-6">
									<h3><%= product.getName()%></h3>
									<div class="input-group">
										<span class="input-group-addon">Name</span> <input
											id="updateName" type="text" class="form-control"
											name="updateName" value="<%= product.getName()%>">
									</div>
									<div class="input-group">
										<span class="input-group-addon">Price</span> <input
											id="updatePrice" type="text" class="form-control"
											name="updatePrice" value="<%= product.getPrice()%>">
									</div>
									<div class="input-group">
										<span class="input-group-addon">Author</span> <input
											id="updateAuthor" type="text" class="form-control"
											name="updateAuthor" value="<%= product.getAuthor()%>">
									</div>
									<div class="input-group">
										<span class="input-group-addon">Description</span>
										<textarea class="form-control" cols="25"
											id="updateDescription" name="updateDescription" rows="5"><%=product.getDescription()%></textarea>
									</div>

									<div class="form-group">
										<button class="btn btn-primary "
											name="updateProduct<%= product.getIdProduct() %>"
											type="submit">Update</button>
										<input type="hidden" id="<%= product.getIdProduct()%>"
											name="hidden" value="<%=product.getIdProduct()%>">
									</div>

									<hr>
								</div>
							</div>
							<%
								}
								}
							%>
						</form>



					</div>
					<div role="tabpanel" class="tab-pane" id="tab3">
						<form action="/si/deleteProduct" method="post">
							<div class="form-group">
								<label for="sel1">User list:</label> <select
									class="form-control" id="sel1" name="deleteProduct">
									<%
										ProductDaoImpl dao = new ProductDaoImpl();
										List<Product> productList = dao.getAllProducts();

										for (Product p : productList) {
											if (p != null) {
									%>
									<option value="<%=p.getName()%>"><%=p.getName()%></option>
									<%
										}
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<button class="btn btn-primary " name="deleteProduct"
									type="submit">Delete</button>

							</div>
						</form>
					</div>

					<div role="tabpanel" class="tab-pane" id="tab4">
						<form action="/si/deleteUser" method="post">
							<div class="form-group">
								<label for="sel1">Product list:</label> <select
									class="form-control" id="sel1" name="deleteUser">
									<%
										UserDaoImpl userDao = new UserDaoImpl();
										List<User> userList = userDao.getAllUserExceptAdmin();

										for (User u : userList) {
											if (u != null) {
									%>
									<option value="<%=u.getUsername()%>"><%=u.getUsername()%></option>
									<%
										}
										}
									%>
								</select>
							</div>
							<div class="form-group">
								<button class="btn btn-primary " name="deleteUser" type="submit">Delete</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>