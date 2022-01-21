<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 17.01.2022
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="l" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/adminStyle.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rajdhani&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Student</title>
</head>
<body>
<header>
    <div class="navbar">
        <a id="logout" href="/">Log out</a>
    </div>
</header>
<div class="body">
    <ul>
        <div class="panel-column">
            <li><a href="/student/score"><i class='fas fa-book-open'></i><span>Score</span></a></li>
            <li><a href="/student/exams"><i class="fas fa-spell-check"></i><span>Exams</span></a></li>
            <li><a href="/student/subjects"><i class='fas fa-user-tie'></i><span>Subject</span></a></li>
        </div>
    </ul>
</div>

</body>
</html>
