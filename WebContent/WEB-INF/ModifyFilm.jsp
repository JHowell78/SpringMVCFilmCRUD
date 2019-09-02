<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateFilm</title>
</head>
<body>
    <a href="index.html">Return to Main Menu</a>
    <h3>Update Film</h3>
    <form:form action="modFilm.do" method="PUT" modelAttribute="film">
    
    <input type="hidden" name="id" value="${film.id}" />
    
        Title: <input type="text" name="title" value="${film.title}"/> <br> 
        <br>
        Description: <input type="text" name="description" value="${film.description}"/> <br> 
        <br>
        Release Year: <input type="number" name="releaseYear" value="${film.releaseYear}"/> <br> 
        <br>
        
        Language: <select name="languageId">
        <option value="1">English</option>
        <option value="2">Italian</option>
        <option value="3">Japanese</option>
        <option value="4">Mandarin</option>
        <option value="5">French</option>
        <option value="6">German</option>
        </select>
        <br>
        
        Rental Duration: <input type="number" name="rentalDuration" value="${film.rentalDuration}"/> <br>
        <br>
        
        Rental Rate: <input type="text" name="rentalRate" value="${film.rentalRate}"/> <br>
        <br>
        
        Length: <input type="number" name="length" value="${film.length}"/> <br> 
        <br>
        
        Replacement Cost: <input type="text" name="replacementCost" value="${film.replacementCost}"/> <br>
        <br>
        
        Rating: <select name="rating">
        <option value="G">G</option>
        <option value="PG">PG</option>
        <option value="PG13">PG-13</option>
        <option value="R">R</option>
        <option value="NC17">NC-17</option>
        </select>
        <br> 
        <br>
        
        Special Features: <br><input type="checkbox" name="specialFeatures" value="Trailers"> Trailers <br>
        <input type="checkbox" name="specialFeatures" value="Commentaries"> Commentaries <br>
        <input type="checkbox" name="specialFeatures" value="Deleted Scenes"> Deleted Scenes <br>
        <input type="checkbox" name="specialFeatures" value="Behind the Scenes"> Behind the Scenes <br>
        
        <input type="submit" name="Update the Film" />
    </form:form>
</body>
</html>