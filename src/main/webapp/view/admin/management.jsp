<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						aria-controls="tab3" role="tab" data-toggle="tab">Delete</a></li>
				</ul>
			</div>
			<div class="col-sm-9">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="tab1">
						<form>

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
									type="file" class="form-control-file" id="addProductImage">
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
						<p>To be continued...</p>
					</div>
					<div role="tabpanel" class="tab-pane" id="tab3">
						<p>To be continued...</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>