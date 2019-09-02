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
    <form:form action="editedFilm.do" method="POST" modelAttribute="film">
    <input type="hidden" name="id" value="${film.id}" />
        Title: <input type="text" name="title" value="${film.title}"/> <br> 
        Description: <input type="text" name="description" value="${film.description}"/> <br> 
        Release Year: <input type="number" name="releaseYear" value="${film.releaseYear}"/> <br> 
        Category: <select name="categoryId">
        <option value="1">Action</option>
        <option value="2">Animation</option>
        <option value="3">Children</option>
        <option value="4">Classics</option>
        <option value="5">Comedy</option>
        <option value="6">Documentary</option>
        <option value="7">Drama</option>
        <option value="8">Family</option>
        <option value="9">Foreign</option>
        <option value="10">Games</option>
        <option value="11">Horror</option>
        <option value="12">Music</option>
        <option value="13">New</option>
        <option value="14">Sci-Fi</option>
        <option value="15">Sports</option>
        <option value="16">Travel</option>
        </select>
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
        Rental Rate: <input type="text" name="rentalRate" value="${film.rentalRate}"/> <br>
        Length: <input type="number" name="length" value="${film.length}"/> <br> 
        Replacement Cost: <input type="text" name="replacementCost" value="${film.replacementCost}"/> <br>
        Rating: <select name="Rating">
        <%-- <option value="${film.rating}"></option> --%>
        <option value="G">G</option>
        <option value="PG">PG</option>
        <option value="PG13">PG-13</option>
        <option value="R">R</option>
        <option value="NC17">NC-17</option>
        </select>
        <br> 
        Special Features: <br>
        <input type="checkbox" name="specialFeatures" value="Trailers"> Trailers <br>
        <input type="checkbox" name="specialFeatures" value="Commentaries"> Commentaries <br>
        <input type="checkbox" name="specialFeatures" value="Deleted Scenes"> Deleted Scenes <br>
        <input type="checkbox" name="specialFeatures" value="Behind the Scenes"> Behind the Scenes <br>
        <br>
        
        <input type="submit" name="Add New Film" value="Edit" />
        
        <input type="submit" name="Delete this Film" value="Delete From Inventory" />
        
    </form:form>    
</body>
</html>






