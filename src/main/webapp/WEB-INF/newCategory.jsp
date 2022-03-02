<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			New Category
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<h1>
			New Category
		</h1>
		<main>
			<form:form method="POST" action="/categories/new" modelAttribute="newCategory">
				<div class="justify">
					<form:label path="name" for="name" class="inp">
						<form:input path="name" type="text" class="inp-input" name="name" id="name" placeholder=" " />
				    	<span class="inp-label">Name</span>
				  		<span class="inp-focus"></span>
				  		<form:errors path="name" class="error"/>
					</form:label>
				</div>
				<button type="submit" class="submit" >
					Create
				</button>
			</form:form>
		</main>
	</body>
</html>