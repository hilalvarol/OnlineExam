<%--
  Created by IntelliJ IDEA.
  User: hilal varol
  Date: 18.01.2022
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Subjects</title>
  <link rel="stylesheet" href=/viewPanel.css">
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
  <div class="container">
    <div class="pack">
      <table>
        <tr>
          <th>ID</th>
          <th>Subject Name</th>
        </tr>

          <tr>
            <c:forEach var="subject" items="${subjects}">
              <c:if test="${lessonTake.subject.id==subject.id}">
                <td>${subject.id}</td>
                <td>${subject.subjectName}</td>
              </c:if>
            </c:forEach>
          </tr>

      </table>
    </div>
  </div>
</div>

</body>
</html>
