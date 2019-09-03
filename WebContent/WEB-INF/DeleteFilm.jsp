<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilmDeleted</title>
</head>
<body>
	<a href="index.html">Home</a>
	<h2>Your Film</h2>
	<c:choose>
		<c:when test="${empty filmAdd}">
			<ul>
				<li>${filmDelete}</li>
			</ul>
				<h3>Has Been Deleted</h3>
		</c:when>
		<c:otherwise>
			<p>Has Not Been Deleted</p>
		</c:otherwise>
	</c:choose>
</body>
</html>