<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 18.01.2022
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Panel</title>
    <link rel="stylesheet" href="/panelUser.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rajdhani&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
<header>
    <div class="navbar">
        <a id="logout" href="/">Log out</a>
    </div>
</header>
<div class="package">
    <a id="add" href="/user/add">Add new User</a>
    <div class="container">
        <div class="pack">
            <table>
                <tr>
                    <th>id</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>User Role</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id1}</td>
                        <td>${user.id}</td>
                        <td>${user.password}</td>
                        <td>${user.role}</td>
                        <td><a href="/user/edit/${user.id1}" class="replay1">Update</a>
                            <a href="/user/delete/${user.id1}" class="replay2">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
</div>

</body>
</html>
