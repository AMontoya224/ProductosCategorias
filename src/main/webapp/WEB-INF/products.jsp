<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Product Page
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
		<script type="text/javascript" src="js/app2.js"></script>
	</head>
	<body>
		<h1>
			<c:out value="${product}"></c:out>
		</h1>
		<main>
			<div>
				<h1>
					Categories:
				</h1>
				<ul>
					<c:forEach var="category" items="${categoriesListYes}">
						<li><c:out value="${category.getName()}"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div>
				<form:form method="POST" action="/products/add" modelAttribute="newProduct">
					<div class="justify">
						<form:label path="categories">
							Add Category:
						</form:label>
						<form:select path="categories">
							<c:forEach var="category" items="${categoriesListNot}">
								<form:option value="${category}">
									<c:out value="${category.getName()}"></c:out>
								</form:option>
							</c:forEach>
						</form:select>
					</div>
					<button type="submit" class="submit" >
						Add
					</button>
				</form:form>
			</div>
		</main>
	</body>
</html>