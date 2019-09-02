<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilmAdded</title>
</head>
<body>
	<a href="index.html">Return to Main Menu</a>
	<h2>Your Film Added</h2>
	<c:choose>
		<c:when test="${! empty filmAdd}">
			<ul>
				<li>${filmAdd}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Film Not Added</p>
		</c:otherwise>
	</c:choose>

	<form action="UPDATEFILM.do" method="GET">
		<br>
		<button type="submit">Update Film</button>
		<input type="hidden" name="id" value="${filmAdd.id}" />
	</form>

	<form:form action="deleteFilm.do" method="POST" modelAttribute="film">
		<input type="hidden" name="id" value="${filmAdd.id}" />
		<input type="submit" name="Delete this Film"
			value="Delete from Inventory" />
	</form:form>


</body>
</html>