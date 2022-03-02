<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			New Product
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<h1>
			New Product
		</h1>
		<main>
			<form:form method="POST" action="/products/new" modelAttribute="newProduct">
				<div class="justify">
					<form:label path="name" for="name" class="inp">
						<form:input path="name" type="text" class="inp-input" name="name" id="name" placeholder=" " />
				    	<span class="inp-label">Name</span>
				  		<span class="inp-focus"></span>
				  		<form:errors path="name" class="error"/>
					</form:label>
				</div>
				<div class="justify">
					<form:label path="description" for="description" class="inp">
						<form:input path="description" type="text" class="inp-input" name="description" id="description" placeholder=" " />
				    	<span class="inp-label">Description</span>
				  		<span class="inp-focus"></span>
				  		<form:errors path="description" class="error"/>
					</form:label>
				</div>
				<div class="justify">
					<form:label path="price" for="price" class="inp">
						<form:input path="price" type="text" class="inp-input" name="price" id="price" placeholder=" " />
				    	<span class="inp-label">Price</span>
				  		<span class="inp-focus"></span>
				  		<form:errors path="price" class="error"/>
					</form:label>
				</div>
				<button type="submit" class="submit" >
					Create
				</button>
			</form:form>
		</main>
	</body>
</html>