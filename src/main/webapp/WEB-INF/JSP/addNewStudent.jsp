<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 19.01.2022
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add New Student</title>
  <link rel="stylesheet" href="/student.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Rajdhani&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
  <form:form modelAttribute="student" action="/student/add"><br>
    <label for="name">Student Name</label>
    <form:input cssClass="studentInput" path="name" placeholder="FirstName" required="true"/> <br/>
    <label for="surname">Student Surname</label>
    <form:input cssClass="studentInput" path="surname" placeholder="Surname" required="true"/><br/>
    <label for="email">Student Email</label>
    <form:input cssClass="studentInput" path="email" placeholder="example@mail.com" required="true"/><br/>
    <input class="button" type="submit" value="Add New Student" name="submit"/>
  </form:form>
</div>
</body>
</html>
