<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 19.01.2022
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add New User</title>
  <link rel="stylesheet" href="/addNewUser.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Rajdhani&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
  <form:form modelAttribute="user" action="/user/add"><br>

    <label for="id">User Email</label>
    <form:input cssClass="userInput" id="userEmail" path="id" placeholder="Email" required="true"/> <br/>
    <label for="password">User Password</label>
    <form:input cssClass="userInput" id="userPassword" path="password" placeholder="Password" required="true"/><br/>

    <h3>User Role</h3>
    <select name="userRole" id="userRole">
      <option value="Admin">Admin</option>
      <option value="Student">Student</option>
    </select>

    <input class="button" type="submit" value="Add New User" name="submit"/>
  </form:form>
</div>
</body>
</html>
