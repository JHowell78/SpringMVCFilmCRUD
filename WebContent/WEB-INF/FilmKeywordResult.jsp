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
    <h2>Find film by keyword: </h2>
    <c:choose>
        <c:when test="${! empty findFilmByKeyword}">
            <ul>
                <li>${filmByKeyword}</li>
            </ul>
        </c:when>
        
        
        <c:otherwise>
            <p>No film found</p>
        </c:otherwise>
    </c:choose>
</body>
</html>

</body>
</html>