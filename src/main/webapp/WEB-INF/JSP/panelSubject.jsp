<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 18.01.2022
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subject Panel</title>
    <link rel="stylesheet" href="/panelSubject.css">
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
    <a id="add" href="/subject/add">Add new Subject</a>
    <div class="container">
        <div class="pack">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Subject Name</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="subject" items="${subjects}">
                    <tr>
                        <td>${subject.id}</td>
                        <td>${subject.name}</td>

                        <td><a href="/subject/edit/${subject.id}" class="replay1">Update</a>
                            <a href="/subject/delete/${subject.id}" class="replay2">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>