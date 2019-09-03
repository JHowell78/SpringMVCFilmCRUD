<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By ID</title>
</head>
<body>
	<a href="index.html">Return to Main Menu</a>
	<br>
	<br>
	<h2>Find film by ID results:</h2>
	<c:choose>
		<c:when test="${! empty filmById}">
			<ul>
				<li>${filmById}</li>
			</ul>
			<br>
		</c:when>


		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<br>
<<<<<<< HEAD
	</h3>
=======
	<br>

>>>>>>> c24efea2383501f688af501aae581f1e1adf6334
	
	<form action="UPDATEFILM.do" method="GET">
		<br>
		<button type="submit">Update/Delete Film</button>
		<input type="hidden" name="id" value="${filmById.id}" />
	</form>
	
</body>
</html>

