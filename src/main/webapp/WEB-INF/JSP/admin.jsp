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
    <title>Admin</title>
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
            <li><a href="/admin"><i class="fas fa-chalkboard-teacher"></i><span>Admin</span></a></li>
            <li><a href="/students"><i class='fas fa-user-graduate'></i><span>Students</span></a></li>
            <li><a href="/subjects"><i class='fas fa-book-open'></i><span>Subjects</span></a></li>
            <li><a href="/users"><i class='fas fa-users'></i><span>Users</span></a></li>
            <li><a href="/exams"><i class='fas fa-building'></i><span>Exams</span></a></li>
        </div>
    </ul>
</div>
</body>
</html>